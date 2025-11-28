package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.constant.BusinessConstant;
import com.book.dao.RoleDao;
import com.book.entity.Role;
import com.book.request.BasePageReq;
import com.book.request.UserRequest;
import com.book.utils.JwtUtil;
import com.book.entity.User;
import com.book.request.UserRegisterRequest;
import com.book.request.LoginRequest;
import com.book.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import com.book.common.CommonResult;

import static com.book.common.CommonResult.failed;
import static com.book.common.CommonResult.success;

/**
 * (User)表控制层
 *
 * @author jojo思密达
 * @since 2025-04-15 12:31:26
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController  {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private  AuthenticationManager authenticationManager;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/getUserList")
    public CommonResult selectAll(BasePageReq req) {
        Page<User> page = new Page<>(req.getCurrent(), req.getSize());
        User user= new User();
        return success(this.userService.selectPage(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult selectOne(@RequestParam("id") Long id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public CommonResult insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody UserRequest request) {

        return success(this.userService.updateUserAndRole(request));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userService.removeByIds(idList));
    }

    /**
     * 用户注册
     * @return
     */
    @PostMapping("/register")
    public CommonResult<String> register(@Valid @RequestBody UserRegisterRequest req) {
        log.info("用户注册==");
        if (!userService.isExistUsername(req.getUserName())) {
            return failed("用户名已存在");
        }
        User user = new User();
        BeanUtils.copyProperties(req,user);
        user.setUserName(req.getUserName());
        user.setPassword(passwordEncoder.encode(req.getPassword())); // BCrypt加密
        user.setEmail(req.getEmail());
        user.setCreater(req.getUserName());
        user.setCreateTime(LocalDateTime.now());
//        user.setRole("USER");
        userService.save(user);
        return success("注册成功");
    }

    /**
     *用户登录
     */
    @PostMapping("/login")
    public CommonResult<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("====用户登录接口========");
        // Redis 限流（Lua脚本）
        String key = "login:fail:" + loginRequest.getUserName();
        Long failCount = redisTemplate.opsForValue().increment(key, 1);

        if (failCount != null && failCount > 5) {
//            return failed("登录过于频繁");
        }
        //验证用户名密码
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

        //生成JWT字符串令牌
        String token = jwtUtil.generateToken(authentication.getName(),
                authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .findFirst()
                        .orElse("USER"));
        //将token存在redis中,并设置过期时间,只是存一下，验证时候暂时不用这个（后续如果做防篡改设定的时候，可以对比一下redis token 和JWT）
        redisTemplate.opsForValue().set((BusinessConstant.TOKEN_PREFIX  + loginRequest.getUserName()), "Bearer " + token, BusinessConstant.EXPIRATION_TIME);

        return success("Bearer " + token);
    }


}



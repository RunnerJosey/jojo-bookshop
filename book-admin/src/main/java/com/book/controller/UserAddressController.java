package com.book.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.UserAddress;
import com.book.service.UserAddressService;
import com.book.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;
import com.book.request.BasePageReq;

/**
 * 书店用户收货地址表(BookUserAddress)表控制层
 *
 * @author jojo思密达
 * @since 2025-12-08 17:46:05
 */
@RestController
@RequestMapping("address")
public class UserAddressController {
    /**
     * 服务对象
     */
    @Resource
    private UserAddressService userAddressService;

    @Autowired
    private HttpRequestUtil httpRequestUtil;

    /**
     * 分页查询当前用户的收货地址
     *
     * @return 地址分页数据
     */
    @GetMapping("selectPage")
    public CommonResult selectAll(BasePageReq req) {
        Long userId = httpRequestUtil.getCurrentUserInfo().getId();
        Page<UserAddress> page = new Page<>(req.getCurrent(), req.getSize());
        QueryWrapper<UserAddress> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId).orderByDesc("is_default").orderByDesc("create_time");
        return success(this.userAddressService.page(page, wrapper));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult selectOne(@RequestParam("id") Long id) {
        return success(this.userAddressService.getById(id));
    }

    /**
     * 新增收货地址
     *
     * @param userAddress 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public CommonResult insert(@RequestBody UserAddress userAddress) {
        LocalDateTime now = LocalDateTime.now();
        userAddress.setUserId(httpRequestUtil.getCurrentUserInfo().getId());
        userAddress.setCreateTime(now);
        userAddress.setUpdateTime(now);
        userAddress.setIsDeleted(0);
        return success(this.userAddressService.save(userAddress));
    }

    /**
     * 修改收货地址
     *
     * @param userAddress 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody UserAddress userAddress) {
        userAddress.setUpdateTime(LocalDateTime.now());
        return success(this.userAddressService.updateById(userAddress));
    }

    /**
     * 删除收货地址
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.userAddressService.removeByIds(idList));
    }
}

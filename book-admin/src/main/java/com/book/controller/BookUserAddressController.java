package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.BookUserAddress;
import com.book.service.BookUserAddressService;
import com.book.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.*;
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
public class BookUserAddressController  {
    /**
     * 服务对象
     */
    @Resource
    private BookUserAddressService bookUserAddressService;
    @Autowired
    private HttpRequestUtil httpRequestUtil;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("selectPage")
    public CommonResult selectAll(BasePageReq req) {
        Page<BookUserAddress> page = new Page<>(req.getCurrent(), req.getSize());
        BookUserAddress bookUserAddress= new BookUserAddress ();
        return success(this.bookUserAddressService.page(page, new QueryWrapper<>(bookUserAddress)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult selectOne(@PathVariable Long id) {
        return success(this.bookUserAddressService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param bookUserAddress 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public CommonResult insert(@RequestBody BookUserAddress bookUserAddress) {
        bookUserAddress.setUserId(httpRequestUtil.getCurrentUserInfo().getId());
        return success(this.bookUserAddressService.save(bookUserAddress));
    }

    /**
     * 修改数据
     *
     * @param bookUserAddress 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody BookUserAddress bookUserAddress) {
        return success(this.bookUserAddressService.updateById(bookUserAddress));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.bookUserAddressService.removeByIds(idList));
    }
}


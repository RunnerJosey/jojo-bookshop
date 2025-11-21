package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.Book;
import com.book.request.BasePageReq;
import com.book.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;

/**
 * (Book)表控制层
 *
 * @author jojo思密达
 * @since 2025-04-17 19:48:41
 */
@RestController
@RequestMapping("book")
@Slf4j
public class BookController  {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping
    public CommonResult selectAll(BasePageReq req) {
        log.info("分页请求参数: current={}, size={}", req.getCurrent(), req.getSize());

        Page<Book> page = new Page<>(req.getCurrent(), req.getSize());
        Book book= new Book();
        Page<Book> result = this.bookService.page(page, new QueryWrapper<>(book));

        log.info("分页结果: total={}, pages={}, current={}, size={}, records.size={}",
                result.getTotal(), result.getPages(), result.getCurrent(),
                result.getSize(), result.getRecords().size());

        // 封装分页结果
        return success(result);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult getById(@RequestParam("id") Long id) {
        return success(this.bookService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param book 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    public CommonResult insert(@RequestBody Book book) {
        return success(this.bookService.save(book));
    }

    /**
     * 修改数据
     *
     * @param book 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public CommonResult update(@RequestBody Book book) {
        return success(this.bookService.updateById(book));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.bookService.removeByIds(idList));
    }
}


package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.Book;
import com.book.service.BookService;
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
public class BookController  {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param book 查询实体
     * @return 所有数据
     */
    @GetMapping
    public CommonResult selectAll(Page<Book> page, Book book) {
        return success(this.bookService.page(page, new QueryWrapper<>(book)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult selectOne(@PathVariable Serializable id) {
        return success(this.bookService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param book 实体对象
     * @return 新增结果
     */
    @PostMapping
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
    @DeleteMapping
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.bookService.removeByIds(idList));
    }
}


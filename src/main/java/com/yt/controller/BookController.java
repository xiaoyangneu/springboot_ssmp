package com.yt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yt.domian.Book;
import com.yt.service.BookService;
import com.yt.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public R getAll() {

        return new R(true, bookService.list());

    }

    @PostMapping
    public R save(@RequestBody Book book) {


        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable int id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {

        return new R(true, bookService.getById(id));
    }

    //    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页面大于总页码值,重新查询，使用最大页码值作为当前页
//        if (currentPage >page.getPages()){
//            page = bookService.getPage((int) page.getPages(),pageSize);
//        }
//        return new R(true, page);
//    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页面大于总页码值,重新查询，使用最大页码值作为当前页
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }
}

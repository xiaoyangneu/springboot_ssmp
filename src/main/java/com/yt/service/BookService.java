package com.yt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yt.domian.Book;

public interface BookService extends IService<Book> {

    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(int id);

    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}

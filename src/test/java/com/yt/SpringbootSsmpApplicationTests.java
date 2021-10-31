package com.yt;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yt.domian.Book;
import com.yt.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootSsmpApplicationTests {

    @Autowired
    BookMapper bookMapper;

    @Test
    void contextLoads() {
        System.out.println(bookMapper.selectById(1));

    }
    @Test
    void getPage() {
        IPage page = new Page(2,3);
        bookMapper.selectPage(page, null);
        System.out.println(page.getRecords());

    }
    @Test
    void get() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like(true,"name","spring");
        bookMapper.selectList(wrapper);

    }
    @Test
    void get1() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(true,Book::getName,"spring");
        bookMapper.selectList(wrapper);

    }

}

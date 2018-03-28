package com.github.zhgxun.words.controllers;

import com.github.zhgxun.models.Book;
import com.github.zhgxun.words.lib.BooksLib;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 图书管理
 */
@RequestMapping("/books")
@RestController
public class Books {

    /**
     * 获取图书列表
     *
     * @return {@link Book} 图书列表
     */
    @RequestMapping("/books")
    public List<Book> books() {
        try {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据图书ID查询图书
     *
     * @param id 图书ID
     * @return {@link Book} 图书对象
     */
    @RequestMapping("/info")
    public Book info(@RequestParam(value = "id") long id) {
        try {
            return BooksLib.info(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加图书
     *
     * @param title     标题
     * @param author    作者
     * @param publisher 出版社
     * @param date      出版日期
     * @return 添加结果
     */
    @RequestMapping("/add")
    public boolean add(@RequestParam(value = "title") String title, @RequestParam(value = "author") String author, @RequestParam(value = "publisher") String publisher, @RequestParam(value = "date") String date) {
        try {
            return BooksLib.add(title, author, publisher, date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除图书
     *
     * @param id      图书ID
     * @return 删除结果
     */
    @RequestMapping("/delete")
    public boolean delete(@RequestParam(value = "id") long id) {
        try {
            return BooksLib.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
package com.example.demoboot.impl;

import com.example.demoboot.DemoBootApplication;
import com.example.demoboot.dao.AuthorDao;
import com.example.demoboot.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoBootApplication.class)
class AuthorDaoJdbcTemplateImplTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testInsert() {
        Author author = new Author();
        author.setId(1L);
        author.setRealName("莫言");
        author.setNickName("疯子");

        authorDao.add(author);
        System.out.println("插入成功！");
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAuthor() {
    }

    @Test
    void findAuthorList() {
    }
}
package com.example.demoboot.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demoboot.dao.AuthorDao;
import com.example.demoboot.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public int add(Author author) {
        String sql = "insert into t_author(id,real_name,nick_name) " +
                "values(:id,:realName,:nickName)";
        Map<String, Object> param = new HashMap<>();
        param.put("id",author.getId()+1);
        param.put("realName", author.getRealName());
        param.put("nickName", author.getNickName());
        jdbcTemplate.update(sql, param);

        return add2(author);
    }

    private int add2(Author author) {
        String sql = "insert into t_author(id,real_name,nick_name) " +
                "values(:id,:realName,:nickName)";
        Map<String, Object> param = new HashMap<>();
        param.put("id",author.getId()+2);
        param.put("realName", author.getRealName()+"1");
        param.put("nickName", author.getNickName());

//        if (1 == 1) {
//            throw new RuntimeException();
//        }

        return (int) jdbcTemplate.update(sql, param);
    }

    @Override
    public int update(Author author) {  
        return 0;
    }

    @Override
    public int delete(Long id) {    
        return 0;
    }

    @Override
    public Author findAuthor(Long id) {
        return null;
    }

    @Override
    public List<Author> findAuthorList() {  
          return null;
    }
}
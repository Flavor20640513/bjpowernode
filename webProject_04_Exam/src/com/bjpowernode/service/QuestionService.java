package com.bjpowernode.service;

import com.bjpowernode.entity.Question;
import com.bjpowernode.util.JdbcUtil;
import com.bjpowernode.util.ReflectUtil;

import java.sql.ResultSet;
import java.util.List;

public interface QuestionService {
    public int insert(Question q) throws Exception;
    public int update(Question q) throws Exception;
    public int delete(int id) throws Exception;
    public List findAll() throws Exception;
    public List rand() throws Exception;
    public int check(String title)throws Exception;
    public Question findById(String id)throws Exception;

}

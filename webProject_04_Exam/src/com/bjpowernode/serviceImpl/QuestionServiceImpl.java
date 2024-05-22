package com.bjpowernode.serviceImpl;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;
import com.bjpowernode.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    QuestionDao dao=new QuestionDao();
    @Override
    public int insert(Question q) throws Exception {
        return dao.insert(q);
    }

    @Override
    public int update(Question q) throws Exception {
        return dao.update(q);
    }

    @Override
    public int delete(int id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List findAll() throws Exception {
        return dao.findAll();
    }

    @Override
    public List rand() throws Exception {
        return dao.rand();
    }

    @Override
    public int check(String title) throws Exception {
        return dao.check(title);
    }

    @Override
    public Question findById(String id) throws Exception {
        return dao.findById(id);
    }
}

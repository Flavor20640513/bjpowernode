package com.bjpowernode;

import com.bjpowernode.entity.Question;
import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

public class Test {
    public static void main(String[] args) throws Exception {
        QuestionService service=new QuestionServiceImpl();
        System.out.println(service.insert(new Question(null, "1", "2", "6", "7", "8", "8")));
    }
}

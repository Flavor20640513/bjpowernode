package com.xcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcl.mapper.UserMapper;
import com.xcl.pojo.User;
import com.xcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getNameAndPass(String userName, String userPass) {
        return userMapper.getNameAndPass(userName, userPass);
    }

    @Override
    public PageInfo<User> selectUserPage(Integer page, Integer PAGE_SIZE) {
        PageHelper.startPage(page, PAGE_SIZE);
        List<User> list=userMapper.selectUserPage();
        PageInfo<User> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public Integer deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    @Override
    public Integer createUser(User user) {
        String temp1=System.currentTimeMillis()+"";
        int temp2=(int)(Math.random()*((9999-1000+1)+1000));
        user.setUserId(temp1+temp2);
        return userMapper.createUser(user);
    }

    @Override
    public User selectUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }
}

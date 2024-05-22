package com.xcl.service;

import com.github.pagehelper.PageInfo;
import com.xcl.pojo.User;

public interface UserService {
    User getNameAndPass(String userName, String userPass);
    PageInfo<User> selectUserPage(Integer page, Integer PAGE_SIZE);
    Integer deleteUserById(String userId);
    Integer createUser(User user);
    User selectUserById(String  userId);
    Integer updateUserById(User user);
}

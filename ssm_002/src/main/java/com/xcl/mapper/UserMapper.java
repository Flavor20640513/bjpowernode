package com.xcl.mapper;

import com.xcl.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User getNameAndPass(@Param("userName") String userName, @Param("userPass") String userPass);
    List<User> selectUserPage();
    Integer deleteUserById(String userId);
    Integer createUser(User user);
    User selectUserById(String  userId);
    Integer updateUserById(User user);
}

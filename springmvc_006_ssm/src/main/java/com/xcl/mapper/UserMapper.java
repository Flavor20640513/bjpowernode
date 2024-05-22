package com.xcl.mapper;

import com.xcl.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * getNameAndPass
     * String userName
     * String userPass
     * 查询到用户返回user对象，查询不到返回null
     */
    User getNameAndPass(@Param("userName") String userName, @Param("userPass") String userPass);
    List<User> selectUserPage();
    Integer deleteUserById(String userId);
    Integer createUser(User user);
    User selectUserById(String  userId);
    Integer updateUserById(User user);
}

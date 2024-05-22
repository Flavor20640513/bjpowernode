package com.xcl.controller;

import com.github.pagehelper.PageInfo;
import com.xcl.pojo.User;
import com.xcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserAction {
    private static final   Integer PAGE_SIZE=5;
    Integer num=0;
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(String userName, String userPass, HttpServletRequest request){
        try {
            User user=userService.getNameAndPass(userName, userPass);
            if (user!=null){
                request.getSession().setAttribute("user", user);
                //取出第1页的数据,放入request对象中,传到main.html页面上显示
                PageInfo<User> info = userService.selectUserPage(1,PAGE_SIZE);
                request.setAttribute("info",info);
                return "main";
            }else {
                request.setAttribute("msg", "账号或密码输入有误");
                return "login";
            }
        }catch (Exception e){
            request.setAttribute("msg", "系统出错!!!!!!");
            return "login";
        }
    }
    @RequestMapping("/selectUserPage")
    public String selectUserPage(Integer page,HttpServletRequest request){
        PageInfo<User> info=userService.selectUserPage(page, PAGE_SIZE);
        request.setAttribute("info", info);
        return "main";
    }

    /**
     * /user/deleteUserById
     * String  userId: 删除用户的id
     * 进行forward:/user/common跳转
     */
    @RequestMapping("/deleteUserById")
    public String deleteUserById(String  userId,HttpServletRequest request){
       try {
           num=userService.deleteUserById(userId);
           return "forward:/user/common";
       }catch (Exception e){
           return "error";
       }
    }
    /**
     * /user/showSave
     * 无
     * 进行save.html页面跳转
     */
    @RequestMapping("/showSave")
    public String showSace(){
        return "save";
    }
    /**
     * /user/createUser
     * String  userId: 用户ID,17位随机数字
     * String  cardType//证件类型
     * String  cardNo//证件号码
     * String  userName//用户姓名
     * String  userSex//用户性别
     * String  userPass//用户密码
     * 进行forward:/user/common跳转
     */
    @RequestMapping("/createUser")
    public String createUser(User user){
        try {
            num=userService.createUser(user);
            return "forward:/user/common";
        } catch (Exception e) {
            return "error";
        }
    }
    /**
     * /user/common
     * HttpServletRequest request
     * 进行main.html或error.html页面跳转
     */
    @RequestMapping("/common")
    public String common(HttpServletRequest request){
        if (num>0){
            PageInfo<User> info = userService.selectUserPage(1,PAGE_SIZE);
            request.setAttribute("info",info);
            return "main";
        }else {
            return "error";
        }
    }
    /**
     * /user/selectUserById
     * String  userId: 用户的主键id
     * 进行update.html页面跳转
     */
    @RequestMapping("/selectUserById")
    public String selectUserById(String userId,HttpServletRequest request){
        User user=userService.selectUserById(userId);
        request.setAttribute("user", user);
        List list=new ArrayList();
        list.add("身份证");
        list.add("军官证");
        list.add("护照");
        list.add("台湾往来大陆通行证");
        list.add("港澳居民通行证");
        request.setAttribute("list", list);
        return "update";
    }
    /**
     * url	/user/updateUserById(参数见以下)
     * 参数	String  userId//用户ID
     * String  cardType//证件类型
     * String  cardNo//证件号码
     * String  userName//用户姓名
     * String  userSex//用户性别
     * String  userPass//用户密码
     * 结果	进行forward:/user/common跳转
     */
    @RequestMapping("/updateUserById")
    public String updateUserById(User user){
        try {
            num=userService.updateUserById(user);
            return "forward:/user/common";
        }catch (Exception e){
            return "error";
        }
    }
}

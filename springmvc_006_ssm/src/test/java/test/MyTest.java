package test;

import com.github.pagehelper.PageInfo;
import com.xcl.pojo.User;
import com.xcl.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//设置测试环境 为Spring接管
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class MyTest {
     @Autowired
    UserService userService;

    /**
     *     User getNameAndPass(String userName, String userPass);
     *     PageInfo<User> selectUserPage(Integer page, Integer PAGE_SIZE);
     *     Integer deleteUserById(String userId);
     *     Integer createUser(User user);
     *     User selectUserById(String  userId);
     *     Integer updateUserById(User user);
     */
    @Test
    public void getNameAndPass(){
        User u = userService.getNameAndPass("张三", "123456");
        System.out.println(u);
    }
    @Test
    public void selectUserPage(){
        PageInfo<User> info=userService.selectUserPage(2, 5);
        System.out.println(info);
    }
    @Test
    public void deleteUserById(){
       int num=userService.deleteUserById("15968954638794962");
        System.out.println(num);
    }
    @Test
    public void createUser(){
      User u=new User("身份证", "351116244512211321", "孔四十s", "男", "1263");
      int num=userService.createUser(u);
    }
    @Test
    public void selectUserById(){
        User u=userService.selectUserById("17162012652335474");
        System.out.println(u);
    }
    @Test
    public void updateUserById(){
       User user=new User("17162012652335474","身份证666", "123332322112333363", "小陈", "女", "89666");
       int num=userService.updateUserById(user);
    }
}

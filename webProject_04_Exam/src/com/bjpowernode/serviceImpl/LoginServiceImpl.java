package com.bjpowernode.serviceImpl;

import com.bjpowernode.dao.EmpDao;
import com.bjpowernode.service.LoginService;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    EmpDao dao=new EmpDao();
    @Override
    public int login(String empNo, String ename) throws SQLException {
        return dao.Login(empNo, ename);
    }
}

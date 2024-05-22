package com.bjpowernode.service;

import java.sql.SQLException;

public interface LoginService {
     public int login(String empNo,String ename) throws SQLException;
}

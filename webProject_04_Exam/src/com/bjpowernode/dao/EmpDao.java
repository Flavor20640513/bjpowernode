package com.bjpowernode.dao;

import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDao {
    public int  Login(String empNo,String ename) throws SQLException {
        String sql="select count(*) from emp where empNo=? and ename=?";   //emoNo和ename做账号密码
        PreparedStatement ps=null;
        JdbcUtil util=new JdbcUtil();
        ResultSet rs=null;
        int result=0;

        try {
            ps=util.getPs(sql);
            ps.setString(1, empNo);
            ps.setString(2, ename);
            rs=ps.executeQuery();
            rs.next();
            result=rs.getInt("count(*)");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
             util.close(rs);
        }
  return result;
    }
}

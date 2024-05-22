package com.bjpowernode.util;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class JdbcUtil {
    String url = "jdbc:mysql://localhost:3306/test";  //"jdbc:mysql://localhost:3306/test";
    String userName = "root";
    String password = "123";
    Connection con = null;
    PreparedStatement ps = null;

    public Connection getCon() throws SQLException, ClassNotFoundException {
       // DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, userName, password);
        return con;
    }

    public PreparedStatement getPs(String sql) throws SQLException, ClassNotFoundException {
        ps = getCon().prepareStatement(sql);
        return ps;
    }
    public void close() throws SQLException {
        if(ps!=null){
            ps.close();
        }
        if (con!=null){
            con.close();
        }
    }
    public void close(ResultSet rs) throws SQLException {
        if (rs!=null){
            rs.close();
        }
        close();
    }
}



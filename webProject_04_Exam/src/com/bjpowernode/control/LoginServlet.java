package com.bjpowernode.control;

import com.bjpowernode.service.LoginService;
import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.LoginServiceImpl;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] array = req.getCookies();
        if (array!=null){
            for (Cookie cookie : array) {
                  if ("lock".equals(cookie.getName())){
                      //为合法用户在网站申请他的私人储物柜[令牌]
                      HttpSession session =req.getSession(true);
                      req.getRequestDispatcher("/index.html").forward(req, resp);
                      return;
                  }
            }
        }
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNo=req.getParameter("empNo");
        String ename=req.getParameter("ename");
        String  ck=null;  //十天免登录
        int result=0;
        LoginService service=new LoginServiceImpl();
        try {
            result=service.login(empNo, ename);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ck=req.getParameter("ck");
        req.setCharacterEncoding("utf-8");
        if (result>0){
            if (ck!=null){
                Cookie card=new Cookie("lock", empNo);
                card.setMaxAge(60*60*24*10);
                resp.addCookie(card);
            }
            //为合法用户在网站申请他的私人储物柜[令牌]
            HttpSession session =req.getSession(true);
            //响应体
            req.getRequestDispatcher("/index.html").forward(req, resp);
            return;
        }
        //3.无法提供有效信息用户，禁止入内
        req.getRequestDispatcher("/login_error.html").forward(req, resp);
    }
}

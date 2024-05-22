package com.bjpowernode.control;

import com.bjpowernode.entity.Question;
import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/add")
public class QuestionAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String title=req.getParameter("title");
        String optionA=req.getParameter("optionA");
        String optionB=req.getParameter("optionB");
        String optionC=req.getParameter("optionC");
        String optionD=req.getParameter("optionD");
        String answer=req.getParameter("answer");
        Question q=new Question(id,title,optionA,optionB,optionC,optionD,answer);
        QuestionService service=new QuestionServiceImpl();
        try {
            service.insert(q);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //重定向
       // resp.sendRedirect("/exam/find");
        //请求与转发 1.请求对象生成 虚拟请求包  2.虚拟请求包发送给Http服务器
        RequestDispatcher rd = req.getRequestDispatcher("/find");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

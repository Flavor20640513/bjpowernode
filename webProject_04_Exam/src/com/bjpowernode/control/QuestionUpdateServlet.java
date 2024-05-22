package com.bjpowernode.control;

import com.bjpowernode.entity.Question;
import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class QuestionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=null;
         int id= Integer.parseInt(req.getParameter("id"));
         String title=req.getParameter("title");
         String optionA=req.getParameter("optionA");
        String optionB=req.getParameter("optionB");
        String optionC=req.getParameter("optionC");
        String optionD=req.getParameter("optionD");
        String answer=req.getParameter("answer");
        QuestionService service=new QuestionServiceImpl();
        Question q=new Question(id, title, optionA, optionB, optionC, optionD, answer);
        int result=0;

        try {
            result=service.update(q);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out=resp.getWriter();
        out.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

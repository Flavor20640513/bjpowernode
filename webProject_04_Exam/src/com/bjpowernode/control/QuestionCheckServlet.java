package com.bjpowernode.control;

import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet("/check")
public class QuestionCheckServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionService service = new QuestionServiceImpl();
        PrintWriter out = null;
        String title=req.getParameter("title");
        int result=0;
        try {
            result=service.check(title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        out=resp.getWriter();
        out.print(result);//122B

        out.close();
    }
}

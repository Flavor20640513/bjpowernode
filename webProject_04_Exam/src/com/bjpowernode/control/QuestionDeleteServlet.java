package com.bjpowernode.control;

import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/del")
public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuestionService service=new QuestionServiceImpl();
        int id= Integer.parseInt(req.getParameter("id"));
        try {
            service.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/exam/find");
    }
}

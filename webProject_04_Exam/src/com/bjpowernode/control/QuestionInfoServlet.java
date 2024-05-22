package com.bjpowernode.control;

import com.bjpowernode.entity.Question;
import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

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
@WebServlet("/info")
public class QuestionInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =null;
        Question question=null;
        String id =req.getParameter("id");
        QuestionService service = new QuestionServiceImpl();
        resp.setContentType("text/html;charset=utf-8");

        //json
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr=null;

        try {
            question=service.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out =resp.getWriter();

      //将对象中属性名和值解析为JSON格式字符串
        jsonStr=mapper.writeValueAsString(question);
        out.print(jsonStr);


        out.close();
    }
}

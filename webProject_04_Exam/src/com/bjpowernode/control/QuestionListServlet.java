package com.bjpowernode.control;

import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/list")
public class QuestionListServlet extends HttpServlet {
    //考试得分
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session=req.getSession(true);
        List<Question> list=null;
        list= (List<Question>) session.getAttribute("list");
        PrintWriter out=resp.getWriter();
        int num=0;
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>题号</td>");
        out.print("<td>题目</td>");
        out.print("<td>A</td>");
        out.print("<td>B</td>");
        out.print("<td>C</td>");
        out.print("<td>D</td>");
        out.print("<td>正确答案</td>");
        out.print("<td>考生答案</td>");
        out.print("</tr>");
        for (Question q : list) {
            String s=req.getParameter(String.valueOf(q.getId()));
            out.print("<tr>");
            out.print("<td>"+q.getId()+"</td>");
            out.print("<td>"+q.getTitle()+"</td>");
            out.print("<td>"+q.getOptionA()+"</td>");
            out.print("<td>"+q.getOptionB()+"</td>");
            out.print("<td>"+q.getOptionC()+"</td>");
            out.print("<td>"+q.getOptionD()+"</td>");
            out.print("<td>"+q.getAnswer()+"</td>");
            out.print("<td>"+s+"</td>");
            if (q.getAnswer().equals(s)){
                num+=25;
            }
            out.print("</tr>");
        }
        out.print("<tr>");
        out.print("<td>得分</td>");
        out.print("<td>"+num+"</td>");
        out.print("</tr>");
        out.print("</table>");
    }
}

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
import java.util.List;
@WebServlet("/find")
public class QuestionFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionService service=new QuestionServiceImpl();
        List<Question> list=null;
        PrintWriter out=null;

        try {
            list=service.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.setContentType("text/html;charset=utf-8");
        out=resp.getWriter();
        out.print("<script type='text/javascript' src='/exam/js/tables.js'></script>");
        out.print("<script type='text/javascript' src='/exam/js/axios.js'></script>");
        out.print("<script type='text/javascript' src='/exam/js/check.js'></script>");
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td><input type='checkbox'/>全选与全不选</td>");
        out.print("<td>题号</td>");
        out.print("<td>题目</td>");
        out.print("<td>A</td>");
        out.print("<td>B</td>");
        out.print("<td>C</td>");
        out.print("<td>D</td>");
        out.print("<td>正确答案</td>");
        out.print("<td>操作</td>");
        out.print("<td>更新</td>");
        out.print("</tr>");
     int num=0;
        for (Question q : list) {
            if (++num %2==0){
                out.print("<tr style='background-color: antiquewhite'>");
            }else {
                out.print("<tr style='background-color: aliceblue'>");
            }
            out.print("<td><input type='checkbox'/></td>");
            out.print("<td>"+q.getId()+"</td>");
            out.print("<td>"+q.getTitle()+"</td>");
            out.print("<td>"+q.getOptionA()+"</td>");
            out.print("<td>"+q.getOptionB()+"</td>");
            out.print("<td>"+q.getOptionC()+"</td>");
            out.print("<td>"+q.getOptionD()+"</td>");
            out.print("<td>"+q.getAnswer()+"</td>");
            out.print("<td><a href='/exam/del?id="+q.getId()+"'>删除试题</a></td>");
            out.print("<td><input type='button' id='btn' value='详情' onclick='window.check("+q.getId()+",event)'/></td>");
            out.print("</tr>");

        }
        out.print("</table>");
        out.flush();
        out.close();
    }
}

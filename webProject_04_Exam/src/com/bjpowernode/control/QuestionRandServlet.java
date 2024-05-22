package com.bjpowernode.control;

import com.bjpowernode.entity.Question;
import com.bjpowernode.service.QuestionService;
import com.bjpowernode.serviceImpl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/rand")
public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(true);
       // session.setMaxInactiveInterval(30);
        QuestionService service=new QuestionServiceImpl();
        List<Question> list=null;
        PrintWriter out=null;
        try {
            list=service.rand();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("list", list);
        resp.setContentType("text/html;charset=utf-8");
        out=resp.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>题号</td>");
        out.print("<td>题目</td>");
        out.print("<td>A</td>");
        out.print("<td>B</td>");
        out.print("<td>C</td>");
        out.print("<td>D</td>");
        out.print("<td>正确答案</td>");
        out.print("</tr>");
        out.print("<form action='/exam/list'");
        for (Question q : list) {
          //  session.setAttribute(String.valueOf(q.getId()),q);//q: (15,1+1=?,12,15,36,55,A)
            out.print("<tr>");
            out.print("<td>"+q.getId()+"</td>");
            out.print("<td>"+q.getTitle()+"</td>");
            out.print("<td>"+q.getOptionA()+"</td>");
            out.print("<td>"+q.getOptionB()+"</td>");
            out.print("<td>"+q.getOptionC()+"</td>");
            out.print("<td>"+q.getOptionD()+"</td>");
            out.print("<td>");
            out.print("A<input type='radio' name='"+q.getId()+"' value='A'>");
            out.print("B<input type='radio' name='"+q.getId()+"' value='B'>");
            out.print("C<input type='radio' name='"+q.getId()+"' value='C'>");
            out.print("D<input type='radio' name='"+q.getId()+"' value='D'>");
            out.print("</td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.print("<input type='submit' value='交卷'>");
        out.print("</form>");

        out.flush();
        out.close();
    }
}

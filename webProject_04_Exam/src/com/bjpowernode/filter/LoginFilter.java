package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);  //令牌机制
        String uri= request.getRequestURI();    //  /exam/xxx   开始的

        //login放行
        if(uri.contains("/login") || "/exam/".equals(uri)){
           filterChain.doFilter(request, servletResponse);
            return;
        }

        //2.其他页面 HttpSession
        if(session!=null){
            filterChain.doFilter(request, servletResponse);
        }else{
            request.getRequestDispatcher("/login_error.html").forward(request, servletResponse);
        }
    }
}

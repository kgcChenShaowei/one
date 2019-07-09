package com.team.house.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王建兵
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2019/7/1 11:33
 * @Created by Administrator
 */


public class CheckLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       HttpServletRequest request=(HttpServletRequest)req;
       HttpServletResponse response=(HttpServletResponse)resp;
       //获取请求的地址
        //System.out.println(request.getRequestURI());   /page/login.jsp
        String uri=request.getRequestURI();
        String path=uri.substring(uri.lastIndexOf("/")+1);
        System.out.println(path);
        //放行 让用户可用进入登入页
        if(path.equals("login.jsp")||path.equals("loginAction")||path.equals( "regs.jsp" )||path.equals( "checkUname" )||path.equals( "reg" )) {
            chain.doFilter(req, resp);
        }else{
            //判断你有没有登入
            HttpSession session=request.getSession();
            Object o=session.getAttribute("loginInfo");
            if(o==null){
                response.sendRedirect("login.jsp");
            }else{
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

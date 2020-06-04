package org.fjnu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wb_Lin
 * @create 2020-05-30 20:10
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user ==null){
            request.setAttribute("message","请先登录!");
            //request.getRequestDispatcher("/adminlogin").forward(request,response);
            response.sendRedirect("/adminlogin");
            return false;
        }
        return true;
    }

}

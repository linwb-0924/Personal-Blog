package org.fjnu.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wb_Lin
 * @create 2020-05-30 10:47
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.addObject("exception",e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}

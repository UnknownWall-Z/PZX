package com.memory.pzp.web.controller.interceptors;

import com.memory.pzp.util.UserContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wall on 2017/9/15.
 */

/***
 * 登陆拦截
 */
public class LoginCheckInterceptors extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 得到当前请求方法
        if(handler instanceof HandlerMethod){
            HandlerMethod hMethod = (HandlerMethod) handler;
            if(hMethod.hasMethodAnnotation(RequireLogin.class) && UserContext.getCurrent()==null){
                response.sendRedirect("login.html");
                return false;
            }
        }
        return super.preHandle(request,response,handler);
    }

}

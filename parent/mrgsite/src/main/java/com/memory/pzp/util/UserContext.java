package com.memory.pzp.util;

/**
 * Created by wall on 2017/9/14.
 */

import com.memory.pzp.base.domain.Logininfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/***
 * 保存和获取当前用户
 */
public class UserContext {

    private static HttpSession session(){
        ServletRequestAttributes sra = (ServletRequestAttributes)
                      RequestContextHolder.getRequestAttributes();
        return sra.getRequest().getSession();
    }
    public static final String SESSION_IN_LOGININFO="logininfo";

    public static void putCurrent(Logininfo logininfo){
        session().setAttribute(SESSION_IN_LOGININFO,logininfo);
    }
    public static Logininfo getCurrent(){
        return (Logininfo) session().getAttribute(SESSION_IN_LOGININFO);
    }

}

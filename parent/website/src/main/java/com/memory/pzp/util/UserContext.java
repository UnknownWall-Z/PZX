package com.memory.pzp.util;

/**
 * Created by wall on 2017/9/14.
 */

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.vo.VerifyPhoneOv;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/***
 * 保存和获取当前用户
 */
public class UserContext {
    /**
     * 存取当前用户
     */
    public static final String SESSION_IN_LOGININFO="logininfo";

    /**
     *  存取手机验证
     */
    public static final String SESSION_IN_VERIFY_PHONE="SESSION_IN_VERIFY_PHONE";

    private static HttpSession session(){
        ServletRequestAttributes sra = (ServletRequestAttributes)
                      RequestContextHolder.getRequestAttributes();
        return sra.getRequest().getSession();
    }

    public static void putCurrent(Logininfo logininfo){
        session().setAttribute(SESSION_IN_LOGININFO,logininfo);
    }
    public static Logininfo getCurrent(){
        return (Logininfo) session().getAttribute(SESSION_IN_LOGININFO);
    }


    public static void putVerifyCode(VerifyPhoneOv verifyPhone){
        session().setAttribute(SESSION_IN_VERIFY_PHONE,verifyPhone);
    }
    public static VerifyPhoneOv getVerfiyCode(){
        return (VerifyPhoneOv) session().getAttribute(SESSION_IN_VERIFY_PHONE);
    }

}

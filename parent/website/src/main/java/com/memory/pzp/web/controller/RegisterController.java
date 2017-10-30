package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.service.ILonginService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wall on 2017/9/12.
 */
@Controller
public class RegisterController {

    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private ILonginService loginService;

    @RequestMapping("/userRegister")
    @ResponseBody
    public ResultAjax register(String username, String password){
//        logger.warn(username+"------日志------"+password);
        try{
            loginService.register(username,password);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultAjax(e.getMessage());
        }
        return new ResultAjax();
    }
    @RequestMapping("checkUsername")
    @ResponseBody
    public boolean check(String username){
        return loginService.checkUsername(username);
    }


    @RequestMapping("userLogin")
    @ResponseBody
    public ResultAjax login(String username,String password,HttpServletRequest req){
        Logininfo logininfo = loginService.userLogin(username, password,req.getRemoteAddr(),Logininfo.COMMON);
        if(logininfo==null){
            return new ResultAjax("账号或密码错误!");
        }else{
            UserContext.putCurrent(logininfo);
        }
        return new ResultAjax();
    }
    @RequestMapping("OutLogin")
    public String outLogin(){
        return "login.html";
    }


}

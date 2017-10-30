package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.service.ILonginService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wall on 2017/9/12.
 */
@Controller
public class LoginController {

    @Autowired
    private ILonginService loginService;


    @RequestMapping("index")
    @ResponseBody
    public ResultAjax index(String username,String password,HttpServletRequest req){
        Logininfo logininfo = loginService.userLogin
                (username, password,req.getRemoteAddr(),Logininfo.MANAGER);
        if(logininfo==null){
            return new ResultAjax("账号或密码错误!");
        }else{
            UserContext.putCurrent(logininfo);
        }
        return new ResultAjax();
    }
    @RequestMapping("userLogin")
    public String login(){
        return "main";
    }

}

package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.service.IVerifyPhoneService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.base.vo.VerifyPhoneOv;
import com.memory.pzp.exp.domain.ExpAccount;
import com.memory.pzp.exp.service.IExpAccountService;
import com.memory.pzp.util.UserContext;
import com.memory.pzp.web.controller.interceptors.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/15.
 */
@Controller
public class PersonalController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IVerifyPhoneService verifyPhoneService;

    @Autowired
    private IExpAccountService expAccountService;

    @RequireLogin
    @RequestMapping("userPersonal")
    public String qersonal(Model model){
        Long id = UserContext.getCurrent().getId();
        Account account = accountService.getByUserId(id);
        Userinfo userinfo = userinfoService.getByUserId(id);
        ExpAccount expaccount = expAccountService.getByUserId(id);
        model.addAttribute("account",account);
        model.addAttribute("userinfo",userinfo);
        model.addAttribute("expaccount",expaccount);
        return "personal";
    }

    @RequestMapping("verifyCode")
    @ResponseBody
    public ResultAjax verifyPhone(String phoneNumber){
        VerifyPhoneOv verifyPhoneOv =
        verifyPhoneService.verifyPhone
        (UserContext.getVerfiyCode(), phoneNumber,UserContext.getCurrent().getId());
        if(verifyPhoneOv==null){
            return new ResultAjax("发送失败");
        }else{
            UserContext.putVerifyCode(verifyPhoneOv);
        }
        return new ResultAjax();
    }

    @RequestMapping("bindPhone")
    @ResponseBody
    public ResultAjax bindPhone(String phoneNumber,String verifyCode){
        boolean judeg = verifyPhoneService.bindPhone(UserContext.getVerfiyCode(),phoneNumber,verifyCode);
        if(!judeg){
           return new ResultAjax("错了");
        }
        return new ResultAjax();
    }

    @RequestMapping("sendEmail")
    @ResponseBody
    public ResultAjax sendEmail(String email){

        try {
            verifyPhoneService.sendEmail(email,UserContext.getCurrent().getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultAjax("邮件发送失败!");
        }

        return new ResultAjax();
    }

    @RequestMapping("verifyEmail")
    public String verifyEmail(String verifyUrl){
        verifyPhoneService.verifyEmail(verifyUrl);
        try{
        }catch (RuntimeException re){
            re.printStackTrace();
        }
        return "checkmail_result";
    }

}

package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.VedioAuthQueryObject;
import com.memory.pzp.base.service.IVedioAuthService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/19.
 */
@Controller
public class VedioController {

    @Autowired
    private IVedioAuthService vedioAuthService;

    @RequestMapping("vedioAuth")
    public String vedioAuth(@ModelAttribute("qo")VedioAuthQueryObject qo,Model model){
        model.addAttribute("pageResult",vedioAuthService.query(qo));
        return "vedioAuth/list";
    }

    @RequestMapping("autocomplate")
    @ResponseBody
    public Integer autocomplate(String username){
        Integer user = vedioAuthService.getUser(username);
        if(user==null){
            return null;
        }
        return user;
    }
    @RequestMapping("vedioAuth_audit")
    @ResponseBody
    public ResultAjax vedioAuthAudit(int loginInfoValue,String remark,int state){

        vedioAuthService.savaApply(loginInfoValue,remark,state,UserContext.getCurrent().getId());
        return new ResultAjax();
    }

}

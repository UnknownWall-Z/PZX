package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.RealAuth;
import com.memory.pzp.base.query.RealAuthQueryObject;
import com.memory.pzp.base.service.IRealAuthService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/18.
 */
@Controller
public class RealAuthController {

    @Autowired
    private IRealAuthService realAuthService;

    @RequestMapping("realAuth")
    public String realAuth(@ModelAttribute("qo")RealAuthQueryObject qo, Model model){
        model.addAttribute("pageResult",realAuthService.query(qo));
        return "realAuth/list";
    }
    @RequestMapping("displayRealAuth")
    @ResponseBody
    public RealAuth displayRealAuth(long rid){
        return realAuthService.get(rid);
    }

    /***
     * 处理审核结果
     * @param id
     * @param remark
     * @param state
     * @return
     */
    @RequestMapping("realAuth_audit")
    @ResponseBody
    public ResultAjax realAuthAudit(long id,String remark,int state){
        realAuthService.applyLook(id,remark,state,UserContext.getCurrent());
        return new ResultAjax();
    }

}

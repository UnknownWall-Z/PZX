package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.IplogQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.service.IIplogService;
import com.memory.pzp.util.UserContext;
import com.memory.pzp.web.controller.interceptors.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wall on 2017/9/14.
 */
@Controller
public class IpLogController {

    @Autowired
    private IIplogService iIplogService;

    @RequireLogin
    @RequestMapping("ipLog")
    public String ipLog(@ModelAttribute("qo")IplogQueryObject qo, Model model){
        model.addAttribute("page",iIplogService.query(qo));
        return "ipLog/list";
    }

    public String ipLogAjax(){
        return "";
    }

}

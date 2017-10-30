package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.IplogQueryObject;
import com.memory.pzp.base.service.IIplogService;
import com.memory.pzp.util.UserContext;
import com.memory.pzp.web.controller.interceptors.RequireLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
        Logininfo current = UserContext.getCurrent();
        if(current!=null){
            qo.setUsername(current.getUsername());
        }
        model.addAttribute("pageResult",iIplogService.query(qo));
        return "iplog_shell";
    }
    @RequestMapping("iplog_list")
    public String iplogAjax(@ModelAttribute("qo")IplogQueryObject qo, Model model){
        Logininfo current = UserContext.getCurrent();
        if(current!=null){
            qo.setUsername(current.getUsername());
        }
        model.addAttribute("pageResult",iIplogService.query(qo));
        return "iplog_list";
    }

}

package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wall on 2017/9/21.
 */
@Controller
public class InvestController {

    @Autowired
    private IBidRequestService bidRequestService;


    @RequestMapping("invest")
    public String invest(){
        return "invest";
    }
    @RequestMapping("invest_list")
    public String investList(@ModelAttribute("qo")BidRequestQueryObject qo, Model model){
        model.addAttribute("bidType",Consts.EXPERIENCE_MONEY_TYPE);
        PageResult pageResult = bidRequestService.query(qo);
        model.addAttribute("pageResult",pageResult);
        return "invest_list";
    }

}

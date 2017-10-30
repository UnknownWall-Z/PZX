package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.base.service.ISystemDictionaryItemService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/16.
 */
@Controller
public class BorrowController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequestMapping("borrow")
    public String borrow(Model model){
        Logininfo current = UserContext.getCurrent();
        if(current!=null){
            Long id = current.getId();
            model.addAttribute("account",accountService.getByUserId(id));
            model.addAttribute("userinfo",userinfoService.getByUserId(id));
            model.addAttribute("creditBorrowScore", Consts.CREDIT_BORROW_SCORE);
            return "borrow";
        }
        return "redirect/borrow.html";
    }

    @RequestMapping("basicInfo")
    public String basicInfo(Model model){
        Long id = UserContext.getCurrent().getId();
        model.addAttribute("userinfo",userinfoService.getByUserId(id));
        model.addAttribute("educationBackgrounds",systemDictionaryItemService.getItemsBySdId(2L));
        model.addAttribute("incomeGrades",systemDictionaryItemService.getItemsBySdId(6L));
        model.addAttribute("marriages",systemDictionaryItemService.getItemsBySdId(3L));
        model.addAttribute("kidCounts",systemDictionaryItemService.getItemsBySdId(4L));
        model.addAttribute("houseConditions",systemDictionaryItemService.getItemsBySdId(5L));
        return "userInfo";
    }

    @RequestMapping("basicInfo_save")
    @ResponseBody
    public ResultAjax saveBasicInfo(Userinfo userinfo){
        Long userId = UserContext.getCurrent().getId();
        userinfoService.updateByUserId(userinfo,userId);
        return new ResultAjax();
    }
}

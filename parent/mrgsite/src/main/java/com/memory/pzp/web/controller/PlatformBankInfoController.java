package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.PlatformBankInfoQueryObject;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.business.domain.PlatformBankInfo;
import com.memory.pzp.business.service.IPlatformBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/21.
 */
@Controller
public class PlatformBankInfoController {

    @Autowired
    private IPlatformBankInfoService platformBankInfoService;

    @RequestMapping("companyBank_list")
    public String platformList(PlatformBankInfoQueryObject qo,Model model){
        PageResult pageResult = platformBankInfoService.query(qo);
        model.addAttribute("pageResult",pageResult);
        return "platformbankinfo/list";
    }

    @RequestMapping("companyBank_update")
    @ResponseBody
    public ResultAjax saveOrUpdate(PlatformBankInfo pb){
        platformBankInfoService.saveOrUpdate(pb);
        return new ResultAjax();
    }

}

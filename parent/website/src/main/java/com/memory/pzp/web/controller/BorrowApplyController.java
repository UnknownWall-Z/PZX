package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.service.IBidRequestService;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/20.
 */
@Controller
public class BorrowApplyController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IBidRequestService bidRequestService;

    @RequestMapping("borrowInfo")
    public String borrowInfo(Model model){
        Long id = UserContext.getCurrent().getId();
        Userinfo user = userinfoService.getByUserId(id);
        if(!user.getHasBidRequest() && user.getHasBasicInfo() &&
              user.getHasRealAuth() && user.getHasVedioAuth()) {
            Account account = accountService.getByUserId(id);
            model.addAttribute("minBidRequestAmount", Consts.SMALLEST_BIDREQUEST_AMOUNT);
            model.addAttribute("minBidAmount", Consts.SMALLEST_BID_AMOUNT);
            model.addAttribute("account", account);
            return "borrow_apply";
        }
        return "borrow_apply_result";
    }

    @RequestMapping("borrow_apply")
    @ResponseBody
    public ResultAjax borrow_apply(BidRequest bidRequest){
        Long id = UserContext.getCurrent().getId();
        Account account = accountService.getByUserId(id);
        bidRequestService.saveBidRequestApply(bidRequest, id, account);
        return new ResultAjax();
    }


}

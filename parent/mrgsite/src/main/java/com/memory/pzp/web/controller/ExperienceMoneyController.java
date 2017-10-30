package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.domain.BidRequestAuditHistory;
import com.memory.pzp.business.service.IBidRequestAuditHistoryService;
import com.memory.pzp.business.service.IBidRequestService;
import com.memory.pzp.exp.service.IExperienceMoneyService;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wall on 2017/9/24.
 */
@Controller
public class ExperienceMoneyController {

    @Autowired
    private IExperienceMoneyService experienceMoneyService;
    @Autowired
    private IBidRequestService bidRequestService;
    @Autowired
    private IBidRequestAuditHistoryService auditHistoryService;

    @RequestMapping("expPublish")
    public String exPublish(Model model){
        model.addAttribute("minBidRequestAmount", Consts.SMALLEST_BIDREQUEST_AMOUNT);
        model.addAttribute("minBidAmount",Consts.SMALLEST_BID_AMOUNT);
        return "expbidrequest/expbidrequestpublish";
    }

    @RequestMapping("expBidRequestPublish")
    @ResponseBody
    public ResultAjax expBidRequestPublish(BidRequest expMessage){
        experienceMoneyService.expPublish(expMessage, UserContext.getCurrent());
        return new ResultAjax();
    }

    @RequestMapping("expBidRequest_list")
    public String expBidRequest_list(@ModelAttribute("qo") BidRequestQueryObject qo, Model model){
        qo.setBidRequestType(Consts.EXPERIENCE_MONEY_TYPE);
        PageResult pageResult = experienceMoneyService.queryExpMessage(qo);
        model.addAttribute("pageResult",pageResult);
        return "expbidrequest/expbidrequestlist";
    }

    @RequestMapping("expBorrow_info")
    public String expBorrowInfo(long id,Model model){
        BidRequest bidRequest = bidRequestService.get(id);
        List<BidRequestAuditHistory> audits = auditHistoryService.listByUserId(id);
        model.addAttribute("bidRequest",bidRequest);
        model.addAttribute("audits",audits);
        return "expbidrequest/borrow_info";
    }
    @RequestMapping("expBid_audit_list")
    public String pending(BidRequestQueryObject qo, Model model){
        qo.setBidRequestType(Consts.EXPERIENCE_MONEY_TYPE);
        qo.setBidRequestState(Consts.EXPERIENCE_MONEY_PUBLISH);
        PageResult query = bidRequestService.query(qo);
        model.addAttribute("pageResult",query);
        return "expbidrequest/emp_audit";
    }

    @RequestMapping("expBid_auditI")
    @ResponseBody
    public ResultAjax expBidAuditI(long id,String remark,byte state){

        experienceMoneyService.auditI(id,remark,state,UserContext.getCurrent());

        return new ResultAjax();
    }
}

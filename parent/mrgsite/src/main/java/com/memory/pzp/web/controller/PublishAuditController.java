package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.base.util.ResultAjax;
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

/***
 * 投标审核
 */
@Controller
public class PublishAuditController {

    @Autowired
    private IBidRequestService bidRequestService;
    /***
     * 借款申请审核
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("bidrequest_publishaudit_list")
    public String publishAudit(BidRequestQueryObject qo, Model model){
        qo.setState((byte)Consts.BIDREQUEST_STATE_PUBLISH_PENDING);
        PageResult query = bidRequestService.query(qo);
        model.addAttribute("pageResult",query);
        return "bidrequest/publish_audit";
    }

    @RequestMapping("bidrequest_publishaudit")
    @ResponseBody
    public ResultAjax publishAuditSave(long id,String remark,int state){
        bidRequestService.saveAudit(id,remark,state, UserContext.getCurrent());
        return new ResultAjax();
    }

    /**
     * 投标审核
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("bidrequest_auditX_list")
    public String pending(BidRequestQueryObject qo, Model model){
        PageResult query = bidRequestService.auditHandle(qo);
        model.addAttribute("pageResult",query);
        return "bidrequest/auditX";
    }

    @RequestMapping("bidrequest_audit")
    @ResponseBody
    public ResultAjax auditX(long id,String remark,byte state){

        bidRequestService.BidAudit(id,remark,state,UserContext.getCurrent());

        return new ResultAjax();
    }
}

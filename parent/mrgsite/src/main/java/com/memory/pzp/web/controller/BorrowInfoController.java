package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.BaseAudit;
import com.memory.pzp.base.domain.RealAuth;
import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.query.UserFilesQueryObject;
import com.memory.pzp.base.service.IRealAuthService;
import com.memory.pzp.base.service.IUserFileService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.domain.BidRequestAuditHistory;
import com.memory.pzp.business.service.IBidRequestAuditHistoryService;
import com.memory.pzp.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wall on 2017/9/21.
 */
@Controller
public class BorrowInfoController {
    @Autowired
    private IBidRequestService bidRequestService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IBidRequestAuditHistoryService historyService;
    @Autowired
    private IRealAuthService realAuthService;
    @Autowired
    private IUserFileService userFileService;

    @RequestMapping("borrow_info")
    public String borrowInfo(long id,Model model){
        BidRequest bidRequest = bidRequestService.get(id);// 申请借款
        Long requestUserId = bidRequest.getCreateUser().getId();
        UserFilesQueryObject qo = new UserFilesQueryObject();
        qo.setState(BaseAudit.STATE_PASS);
        qo.setIsPaging(0);
        Userinfo userInfo = userinfoService.getByUserId(requestUserId);// 借款人
        RealAuth realAuth = realAuthService.get(userInfo.getRealAuthId());// 借款人实名认证
        List<UserFile> userFiles = userFileService.listByState(qo);// 风控材料
        List<BidRequestAuditHistory> audits = historyService.listByUserId(requestUserId);// 所有审核
        model.addAttribute("bidRequest",bidRequest);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("audits",audits);
        model.addAttribute("realAuth",realAuth);
        model.addAttribute("userFiles",userFiles);
        return "bidrequest/borrow_info";
    }


}

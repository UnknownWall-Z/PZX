package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.*;
import com.memory.pzp.base.query.UserFilesQueryObject;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.base.service.IRealAuthService;
import com.memory.pzp.base.service.IUserFileService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.service.IBidRequestService;
import com.memory.pzp.exp.domain.ExpAccount;
import com.memory.pzp.exp.service.IExpAccountService;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wall on 2017/9/21.
 */
@Controller
public class BorrowInfoController {

    @Autowired
    private IBidRequestService bidRequestService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IRealAuthService realAuthService;
    @Autowired
    private IUserFileService userFileService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IExpAccountService expAccountService;
    /***
     * 借款详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("borrow_info")
    public String borrowInfo(long id,Model model){
        BidRequest bidRequest = bidRequestService.get(id);// 申请借款
        model.addAttribute("bidRequest",bidRequest);
        Logininfo current = UserContext.getCurrent();
        if(current!=null){

            Long userId = bidRequest.getCreateUser().getId();
            if(userId==current.getId()){
                model.addAttribute("self",true);
            }else{
                Account account = accountService.getByUserId(userId);//余额相关
                model.addAttribute("account",account);
            }
            Userinfo userInfo = userinfoService.getByUserId(userId);
            RealAuth realAuth = realAuthService.get(userId);// 借款人实名认证
            UserFilesQueryObject qo = new UserFilesQueryObject();
            qo.setState(BaseAudit.STATE_PASS);
            qo.setIsPaging(0);
            qo.setApplierId(userId);
            List<UserFile> userFiles = userFileService.listByState(qo);// 风控材料
            model.addAttribute("realAuth",realAuth);
            model.addAttribute("userInfo",userInfo);
            model.addAttribute("userFiles",userFiles);
        }
        return "borrow_info";
    }

    /***
     * 借款投标入口
     * @param amount
     * @param bidRequestId
     * @return
     */
    @RequestMapping("borrow_bid")
    @ResponseBody
    public ResultAjax borrow_bid(BigDecimal amount,long bidRequestId){
        try{
            bidRequestService.firstBid(amount,bidRequestId,UserContext.getCurrent());
        }catch (RuntimeException e){
            return new ResultAjax("投资失败!");
        }
        return new ResultAjax();

    }
    /***
     * 活动标详情查询
     * @return
     */
    @RequestMapping("expBorrow_info")
    public String expBorrow_info(long id,Model model){
        BidRequest bidRequest = bidRequestService.get(id);// 申请借款
        model.addAttribute("bidRequest",bidRequest);
        Logininfo current = UserContext.getCurrent();

        if(current!=null){
            ExpAccount expAccount = expAccountService.getByUserId(current.getId());
            model.addAttribute("expAccount",expAccount);
        }
        return "exp_borrow_info";
    }
    @RequestMapping("exp_borrow_bid")
    @ResponseBody
    public ResultAjax exp_borrow_bid(long bidRequestId,BigDecimal amount){
        try{

            bidRequestService.expBid(amount,bidRequestId,UserContext.getCurrent());
        }catch (RuntimeException e){
            return new ResultAjax("投资失败!");
        }
        return new ResultAjax();
    }

}

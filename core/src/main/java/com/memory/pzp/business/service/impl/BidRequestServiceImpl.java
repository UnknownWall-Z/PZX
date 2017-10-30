package com.memory.pzp.business.service.impl;

import com.memory.pzp.base.domain.Account;
import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.util.BitStatesUtils;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.business.domain.Bid;
import com.memory.pzp.business.mapper.BidMapper;
import com.memory.pzp.business.service.IAccountFlowService;
import com.memory.pzp.exp.domain.ExpAccount;
import com.memory.pzp.exp.service.IExpAccountService;
import org.apache.commons.lang.time.DateUtils;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.domain.BidRequestAuditHistory;
import com.memory.pzp.business.mapper.BidRequestAuditHistoryMapper;
import com.memory.pzp.business.mapper.BidRequestMapper;
import com.memory.pzp.business.service.IBidRequestService;
import com.memory.pzp.business.util.CalculatetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wall on 2017/9/20.
 */
@Service
@Transactional
public class BidRequestServiceImpl implements IBidRequestService {

    @Autowired
    private IAccountFlowService accountFlowService;
    @Autowired
    private BidRequestMapper bidRequestMapper;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private BidRequestAuditHistoryMapper auditHistoryMapper;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IExpAccountService expAccountService;
    @Autowired
    private BidMapper bidMapper;

    @Override
    public BidRequest get(long id) {
        return this.bidRequestMapper.selectByPrimaryKey(id);
    }

    public void saveExpPublish(BidRequest er){
        this.bidRequestMapper.insert(er);
    }


    @Override
    public void update(BidRequest bidRequest) {
        int ret = bidRequestMapper.updateByPrimaryKey(bidRequest);
        if(ret<=0){
            throw new RuntimeException("乐观锁失败"+bidRequest.getId());
        }
    }

    @Override
    public PageResult query(BidRequestQueryObject qo) {

        int count = this.bidRequestMapper.count(qo);
        if(count>0){
            List<BidRequest> listData = this.bidRequestMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }
    @Override
    public PageResult expQuery(BidRequestQueryObject qo) {

        int count = this.bidRequestMapper.count(qo);
        if(count>0){
            List<BidRequest> listData = this.bidRequestMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }


    @Override
    public void saveBidRequestApply(BidRequest br,long id,Account account) {
        Userinfo user = userinfoService.getByUserId(id);
        if(!user.getHasBidRequest() && user.getHasBasicInfo() &&
                user.getHasRealAuth()   && user.getHasVedioAuth() &&
                user.getScore()>= Consts.CREDIT_BORROW_SCORE      &&
                br.getBidRequestAmount().compareTo(Consts.SMALLEST_BIDREQUEST_AMOUNT)>=0 &&
                br.getMinBidAmount().compareTo(Consts.SMALLEST_BID_AMOUNT)>=0            &&
                br.getBidRequestAmount().compareTo(account.getBorrowLimitAmount())<=0    &&
                br.getCurrentRate().compareTo(Consts.SMALLEST_CURRENT_RATE)>=0           &&
                br.getCurrentRate().compareTo(Consts.MAX_CURRENT_RATE)<=0
                ) {
            Logininfo logininfo = new Logininfo();
            logininfo.setId(id);
            BidRequest b = new BidRequest();
            b.setCreateUser(logininfo);
            b.setApplyTime(new Date());
            b.setBidRequestAmount(br.getBidRequestAmount());
            b.setCurrentRate(br.getCurrentRate());
            b.setMonthes2Return(br.getMonthes2Return());
            b.setTitle(br.getTitle());
            b.setDescription(br.getDescription());
            b.setDisableDays(br.getDisableDays());
            b.setMinBidAmount(br.getMinBidAmount());
            b.setReturnType(br.getReturnType());
            b.setBidRequestType((byte) Consts.BIDREQUEST_TYPE_NORMAL);
            b.setBidRequestState((byte)Consts.BIDREQUEST_STATE_PUBLISH_PENDING);
            b.setTotalRewardAmount(CalculatetUtil.calTotalInterest(
                    br.getReturnType(), br.getBidRequestAmount(),
                    br.getCurrentRate(), br.getMonthes2Return()));
            this.bidRequestMapper.insert(b);
            user.setBitState(BitStatesUtils.addState(user.getBitState(),BitStatesUtils.HAS_BIDREQUEST_IN_PROCESS));
            userinfoService.update(user);
        }

    }

    @Override
    public void saveAudit(long id, String remark, int state, Logininfo current) {
        BidRequest br = bidRequestMapper.selectByPrimaryKey(id);
        if(br!=null && br.getBidRequestState()==Consts.BIDREQUEST_TYPE_NORMAL){
            Userinfo user = userinfoService.getByUserId(br.getCreateUser().getId());
            BidRequestAuditHistory bh = new BidRequestAuditHistory();
            bh.setAuditType((byte)Consts.BIDREQUEST_TYPE_NORMAL);
            bh.setBidrequestId(id);
            bh.setApplyTime(br.getApplyTime());
            bh.setAuditor(current);
            bh.setApplier(br.getCreateUser());
            bh.setRemark(remark);
            bh.setAuditTime(new Date());
            bh.setState((byte)state);
            auditHistoryMapper.insert(bh);
            if(state==BidRequestAuditHistory.STATE_PASS){
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_BIDDING);
                br.setPublishTime(new Date());
                br.setDisableDate(DateUtils.addDays(br.getPublishTime(),
                br.getDisableDays()));

            }else{
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_UNDO);
                user.setBitState(BitStatesUtils.removeState(user.getBitState(),
                                 BitStatesUtils.HAS_BIDREQUEST_IN_PROCESS));
               userinfoService.update(user);
            }

            this.update(br);
        }
    }

    @Override
    public List<BidRequest> bidding(BidRequestQueryObject qo) {
        return bidRequestMapper.listData(qo);
    }

    @Override
    public void expBid(BigDecimal amount, long bidRequestId, Logininfo current) {
        long userId = current.getId();
        BidRequest br = bidRequestMapper.selectByPrimaryKey(bidRequestId);
        ExpAccount expAccount = expAccountService.getByUserId(userId);
        BigDecimal usableAmount = expAccount.getUsableAmount();
        if(br!=null && br.getBidRequestState()==Consts.BIDREQUEST_STATE_BIDDING
                && br.getBidRequestType()==Consts.EXPERIENCE_MONEY_TYPE
                && br.getBidRequestAmount().compareTo(br.getCurrentSum())>0
                && amount.compareTo(usableAmount)<=0
                && amount.compareTo(br.getMinBidAmount())>=0
        ){
            Bid bi = new Bid();

            if(amount.compareTo(br.getRemainAmount())>=0){
                BigDecimal remainder = br.getBidRequestAmount().subtract(br.getCurrentSum());
                bi.setAvailableAmount(remainder);
                expAccount.setUsableAmount(usableAmount.subtract(remainder));
                expAccount.setFreezedAmount(expAccount.getFreezedAmount().add(remainder));
                br.setCurrentSum(br.getCurrentSum().add(remainder));
                accountFlowService.expBidFlow(expAccount,remainder);
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_APPROVE_PENDING_1);
                bidMapper.updateStates(Consts.BIDREQUEST_STATE_APPROVE_PENDING_1,bidRequestId);
            }else{
                bi.setAvailableAmount(amount);
                expAccount.setUsableAmount(usableAmount.subtract(amount));
                expAccount.setFreezedAmount(expAccount.getFreezedAmount().add(amount));
                br.setCurrentSum(br.getCurrentSum().add(amount));
                accountFlowService.expBidFlow(expAccount,amount);
            }
            bi.setActualRate(br.getTotalRewardAmount());
            bi.setBidRequest(br);
            bi.setBidUser(current);
            bi.setBidTime(new Date());
            bi.setBidRequestTitle(br.getTitle());
            br.setBidCount(br.getBidCount()+1);
            update(br);
            expAccountService.update(expAccount);
            bi.setBidRequestState((byte)Consts.BIDREQUEST_STATE_BIDDING);
            bidMapper.insert(bi);
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public void firstBid(BigDecimal amount, long bidRequestId, Logininfo current) {
        long userId = current.getId();
        BidRequest br = bidRequestMapper.selectByPrimaryKey(bidRequestId);
        Account bidAccount = accountService.getByUserId(userId);
        BigDecimal usableAmount = bidAccount.getUsableAmount();

        if(br!=null && br.getBidRequestState()==Consts.BIDREQUEST_STATE_BIDDING
                    && br.getCreateUser().getId()!=userId
                    && br.getBidRequestAmount().compareTo(br.getCurrentSum())>0
                    && amount.compareTo(usableAmount)<=0
                    && amount.compareTo(br.getMinBidAmount())>=0
          ){

            Bid bi = new Bid();

            if(amount.compareTo(br.getRemainAmount())>=0){
                BigDecimal remainder = br.getBidRequestAmount().subtract(br.getCurrentSum());
                bi.setAvailableAmount(remainder);
                bidAccount.setUsableAmount(usableAmount.subtract(remainder));
                bidAccount.setFreezedAmount(bidAccount.getFreezedAmount().add(remainder));
                br.setCurrentSum(br.getCurrentSum().add(remainder));
                accountFlowService.bidFlow(bidAccount,remainder);
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_APPROVE_PENDING_1);
                bidMapper.updateStates(Consts.BIDREQUEST_STATE_APPROVE_PENDING_1,bidRequestId);
            }else{
                bi.setAvailableAmount(amount);
                bidAccount.setUsableAmount(usableAmount.subtract(amount));
                bidAccount.setFreezedAmount(bidAccount.getFreezedAmount().add(amount));
                br.setCurrentSum(br.getCurrentSum().add(amount));
                accountFlowService.bidFlow(bidAccount,amount);
            }
            bi.setActualRate(br.getTotalRewardAmount());
            bi.setBidRequest(br);
            bi.setBidUser(current);
            bi.setBidTime(new Date());
            bi.setBidRequestTitle(br.getTitle());
            br.setBidCount(br.getBidCount()+1);
            update(br);
            accountService.update(bidAccount);
            bi.setBidRequestState((byte)Consts.BIDREQUEST_STATE_BIDDING);
            bidMapper.insert(bi);
        }else {
            throw new RuntimeException();
        }

    }

    @Override
    public PageResult auditHandle(BidRequestQueryObject qo) {
        qo.setState((byte)Consts.BIDREQUEST_STATE_APPROVE_PENDING_1);
        int count = this.bidRequestMapper.countAudit(qo);
        if(count>0){
            List<BidRequest> listData = this.bidRequestMapper.auditData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public void BidAudit(long id, String remark, byte state, Logininfo current) {
        BidRequest br = bidRequestMapper.selectByPrimaryKey(id);

        if( br!=null && br.getBidRequestState() == Consts.BIDREQUEST_STATE_APPROVE_PENDING_1){
            BidRequestAuditHistory audit = new BidRequestAuditHistory();
            audit.setState(state);
            audit.setAuditTime(new Date());
            audit.setAuditor(current);
            audit.setAuditType((byte)Consts.BIDREQUEST_STATE_APPROVE_PENDING_1);

            if(state == BidRequestAuditHistory.STATE_PASS){


                // 1.1,借款状态
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_PAYING_BACK);
                Account RequestAccount = accountService.getByUserId(br.getCreateUser().getId());


                System.out.println("--->"+RequestAccount);

                // 借款成功,可用金额增加,生成流水;
//                accountFlowService.createBorrowSuccessFlow(RequestAccount, br);
                // 2.2,剩余信用额度减少;
                RequestAccount.setRemainBorrowLimit(RequestAccount.getRemainBorrowLimit().subtract(
                br.getBidRequestAmount()));


                // 2.3,代还总金额增加;
                RequestAccount.setUnReturnAmount(RequestAccount
                        .getUnReturnAmount().add(br.getBidRequestAmount())
                        .add(br.getTotalRewardAmount()));
                // 2.4,去掉借款状态码;
                Userinfo RequestUser = this.userinfoService.getByUserId(RequestAccount .getId());
                RequestUser.setBitState(BitStatesUtils.removeState
                        (RequestUser.getBitState(),BitStatesUtils.HAS_BIDREQUEST_IN_PROCESS));

                BigDecimal manageFee = CalculatetUtil
                        .calAccountManagementCharge(br.getBidRequestAmount());
                RequestAccount.setUsableAmount(RequestAccount.getUsableAmount()
                        .subtract(manageFee));
//                accountFlowService.createManageFeeFlow(RequestAccount, manageFee, br);
                // 2.6,系统账户收取手续费,生成系统账户流水;
//                this.systemAccountService.chargeManageFee(manageFee, br);

                System.out.println("<---"+RequestAccount);

                // 3,投资人;
                // 3.1,遍历投标;
                Map<Long, Account> updates = new HashMap<>();
                for (Bid bid : br.getBids()) {
                    // 3.2,投标成功,冻结减少,生成流水;
                    Long accountId = bid.getBidUser().getId();
                    Account bidAccount = updates.get(accountId);

                    System.out.println("前--->"+bidAccount);

                    if (bidAccount == null) {
                        bidAccount = this.accountService.getByUserId(bid.getBidUser()
                                .getId());
                        updates.put(accountId, bidAccount);
                    }
                    bidAccount.setFreezedAmount(bidAccount.getFreezedAmount()
                            .subtract(bid.getAvailableAmount()));
//                    this.accountFlowService.createBidSuccessFlow(bidAccount, bid);

                    System.out.println("后<---"+bidAccount);

                }


            }else{
                System.out.println("审核失败");
            }
        }
    }

    private void cancelBid(BidRequest br) {
        // 审核拒绝;
        // 1,修改借款状态,2,修改投标对象状态;
        br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_REJECTED);
        // 3,遍历投标对象,还款;冻结金额减少,可用余额增加,生成投标失败流水;
        // 4,借款人去掉状态码
    }

}

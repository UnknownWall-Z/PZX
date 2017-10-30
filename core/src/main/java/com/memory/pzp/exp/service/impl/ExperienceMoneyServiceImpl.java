package com.memory.pzp.exp.service.impl;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.domain.BidRequestAuditHistory;
import com.memory.pzp.business.mapper.BidRequestAuditHistoryMapper;
import com.memory.pzp.business.service.IBidRequestService;
import com.memory.pzp.business.util.CalculatetUtil;
import com.memory.pzp.exp.service.IExperienceMoneyService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by wall on 2017/9/24.
 */
@Service
public class ExperienceMoneyServiceImpl implements IExperienceMoneyService{

    @Autowired
    private IBidRequestService bidRequestService;
    @Autowired
    private BidRequestAuditHistoryMapper auditHistoryMapper;

    @Override
    public void expPublish(BidRequest ee, Logininfo userBoss) {

        if(ee!=null && ee.getBidRequestAmount().compareTo( Consts.SMALLEST_BIDREQUEST_AMOUNT)>=0
                    && ee.getMinBidAmount().compareTo(Consts.SMALLEST_BID_AMOUNT)>=0
          ){
            BidRequest er = new BidRequest();
            er.setBidRequestState(Consts.EXPERIENCE_MONEY_PUBLISH);
            er.setBidRequestType(Consts.EXPERIENCE_MONEY_TYPE);
            er.setCreateUser(userBoss);
            er.setBidRequestAmount(ee.getBidRequestAmount());
            er.setMinBidAmount(ee.getMinBidAmount());
            er.setDisableDays(ee.getDisableDays());
            er.setTitle(ee.getTitle());
            er.setMonthes2Return(ee.getMonthes2Return());
            er.setCurrentRate(ee.getCurrentRate());
            er.setReturnType(ee.getReturnType());
            er.setPublishTime(new Date());
            er.setTotalRewardAmount(CalculatetUtil.calTotalInterest(
                    er.getReturnType(), er.getBidRequestAmount(),
                    er.getCurrentRate(), er.getMonthes2Return()));
            bidRequestService.saveExpPublish(er);
        }
    }

    @Override
    public PageResult queryExpMessage(BidRequestQueryObject qo) {
        return bidRequestService.query(qo);
    }

    @Override
    public void auditI(long id, String remark, byte state, Logininfo current) {

        BidRequest br = bidRequestService.get(id);
        if(br!=null && br.getBidRequestState()==Consts.EXPERIENCE_MONEY_PUBLISH){
            BidRequestAuditHistory bh = new BidRequestAuditHistory();
            bh.setAuditType(Consts.EXPERIENCE_MONEY_TYPE);
            bh.setBidrequestId(id);
            bh.setAuditor(current);
            bh.setApplier(br.getCreateUser());
            bh.setRemark(remark);
            bh.setAuditTime(new Date());
            bh.setState(state);
            auditHistoryMapper.insert(bh);
            if(state==BidRequestAuditHistory.STATE_PASS){
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_BIDDING);
                br.setPublishTime(new Date());
                br.setDisableDate(DateUtils.addDays(br.getPublishTime(),
                        br.getDisableDays()));

            }else{
                br.setBidRequestState((byte)Consts.BIDREQUEST_STATE_UNDO);
            }
            bidRequestService.update(br);
        }
    }
}

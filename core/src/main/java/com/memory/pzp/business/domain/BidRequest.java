package com.memory.pzp.business.domain;

import com.alibaba.fastjson.JSON;
import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.business.util.CalculatetUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.memory.pzp.base.util.Consts.*;

@Setter@Getter@ToString
public class BidRequest {

    private Long id;

    private Integer version;

    private Byte bidRequestType;

    private Byte bidRequestState;

    private BigDecimal bidRequestAmount;

    private BigDecimal currentRate;

    private Byte monthes2Return;

    private int bidCount;

    private BigDecimal totalRewardAmount;

    private BigDecimal currentSum=Consts.ZERO;

    private String title;

    private String description;

    private String note;

    private Date disableDate;

    private Logininfo createUser;

    private java.util.List<Bid> Bids = new ArrayList<>();

    private Byte disableDays;

    private BigDecimal minBidAmount;

    private Date applyTime;

    private Date publishTime;

    private int returnType;

    /***
     * 是否活动体验金
     * @return
     *  true > 是活动金
     *  false > 其他标
     */
    public boolean getHasExpType(){
        return bidRequestType==Consts.EXPERIENCE_MONEY_TYPE?true:false;
    }

    /***
     * 标的类型
     * @return
     */
    public String getBidRequestTypeDisplay(){
        switch (bidRequestType){
            case Consts.BIDREQUEST_TYPE_NORMAL:return "普通信用标";
            case Consts.EXPERIENCE_MONEY_TYPE: return "活动体验标";
        }
        return "黑标";
    }

    public Map<String, Object> getJsonObject() {
        Map<String, Object> json = new HashMap<>();
        json.put("id", id);
        json.put("username", this.createUser.getUsername());
        json.put("title", title);
        json.put("bidRequestAmount", bidRequestAmount);
        json.put("currentRate", currentRate);
        json.put("monthes2Return", monthes2Return);
        json.put("returnType", this.getReturnTypeDisplay());
        json.put("totalRewardAmount", totalRewardAmount);
        return json;
    }

    public int getPersent() {
        return this.currentSum
                .divide(bidRequestAmount, Consts.DISPLAY_SCALE,
                        RoundingMode.HALF_UP)
                .multiply(CalculatetUtil.ONE_HUNDRED).intValue();
    }

    public String getJsonString() {
        return JSON.toJSONString(getJsonObject());
    }


    public String getReturnTypeDisplay() {
        return this.returnType == RETURN_TYPE_MONTH_INTEREST_PRINCIPAL ? "等额本息"
                : "先息后本";
    }

    /**
     * 得到剩余金额
     *
     * @return
     */
    public BigDecimal getRemainAmount() {
        return this.bidRequestAmount.subtract(this.currentSum);
    }


    public String getBidRequestStateDisplay() {
      return Consts.getbidrequeststatedisplay(this.bidRequestState);
    }

}
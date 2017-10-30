package com.memory.pzp.business.domain;

import com.memory.pzp.base.domain.Logininfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter@ToString
public class Bid {

    private Long id;

    private BigDecimal actualRate;

    private BigDecimal availableAmount;

    private BidRequest bidRequest;

    private Logininfo bidUser;

    private Date bidTime;

    private String bidRequestTitle;

    private Byte bidRequestState;

}
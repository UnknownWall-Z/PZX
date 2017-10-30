package com.memory.pzp.exp.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter
public class ExpAccountFlow {

    private Long id;

    private Byte actionType;//交易类型

    private BigDecimal amount;//交易金额

    private String note;// 说明

    private BigDecimal usableAmount;//交易后体验金账户余额

    private BigDecimal freezedAmount;//交易后体验金账户冻结

    private Date actionTime;// 交易时间

    private Long expAccountId;// 体验金账户

}
package com.memory.pzp.business.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter
public class AccountFlow {

    private Long id;

    private Byte accountActionType;

    private BigDecimal amount;

    private String note;

    private BigDecimal balance;

    private BigDecimal freezed;

    private Date actionTime;

    private long accountId;

}
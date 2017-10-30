package com.memory.pzp.business.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter
public class SystemAccountFlow {

    private Long id;

    private Date createdDate;

    private Byte accountactiontype;

    private BigDecimal amount;

    private String note;

    private BigDecimal balance;

    private BigDecimal freezedAmount;

    private Long targetuserId;

}
package com.memory.pzp.business.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter@Getter
public class SystemAccount {

    private Long id;

    private Integer version;

    private BigDecimal totalbalance;

    private BigDecimal freezedamount;

}
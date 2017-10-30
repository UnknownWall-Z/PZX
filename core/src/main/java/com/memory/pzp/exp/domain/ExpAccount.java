package com.memory.pzp.exp.domain;

import com.memory.pzp.base.util.Consts;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter@Getter@ToString
public class ExpAccount {

    private Long id;

    private Integer version;

    private BigDecimal usableAmount = Consts.ZERO;// 体验金余额

    private BigDecimal freezedAmount = Consts.ZERO;// 体验金冻结金额

    private BigDecimal unReturnExpAmount = Consts.ZERO;// 临时垫收体验金


}
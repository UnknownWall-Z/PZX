package com.memory.pzp.base.domain;

import com.memory.pzp.base.util.Consts;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter@Getter@ToString
public class Account {

    private Long id;

    private Integer version;

    private String tradePassword;

    private BigDecimal usableAmount=Consts.ZERO;

    private BigDecimal freezedAmount=Consts.ZERO;

    private BigDecimal borrowLimitAmount=Consts.DEFALUT_BORROW_LIMIT;

    private BigDecimal unReceiveInterest=Consts.ZERO;

    private BigDecimal unReceivePrincipal=Consts.ZERO;

    private BigDecimal unReturnAmount=Consts.ZERO;

    private BigDecimal remainBorrowLimit=Consts.DEFALUT_BORROW_LIMIT;

    public BigDecimal getSumAmount(){
        return usableAmount.add(freezedAmount).add(unReceivePrincipal);
    }
}
package com.memory.pzp.exp.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter@Getter
public class ExpAccountGrantrecord {

    public static final byte STATE_MORMAL = 0;//正常
    public static final byte STATE_RETURN = 1;//已回收

    private Long id;

    private Long grantUserId;// 对应用户

    private BigDecimal amount;// 发放金额

    private Date grantDate;// 发放时间

    private Date returnDate;// 到期时间

    private Byte grantType;// 发放类型

    private String note;// 说明

    private Byte state;// 当前状态

}
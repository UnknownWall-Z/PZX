package com.memory.pzp.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by wall on 2017/9/20.
 */
@Setter@Getter
public class ObjectAudit {

    protected Byte state;

    protected String remark;

    protected Date auditTime;

    protected Date applyTime;

    protected Logininfo auditor;

    protected Logininfo applier;

    /***
     * 认证的三个状态
     */
    public static final byte STATE_NORMAL = 0;// 待审核
    public static final byte STATE_PASS = 1; // 通过审核
    public static final byte STATE_REJECT = 2; //审核拒绝
    public String getStateDisplay() {
        switch (state) {
            case STATE_NORMAL:
                return "待审核";
            case STATE_PASS:
                return "通过审核";
            case STATE_REJECT:
                return "残忍拒绝";
            default:return"";
        }
    }
}

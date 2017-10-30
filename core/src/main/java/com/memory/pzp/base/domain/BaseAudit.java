package com.memory.pzp.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by wall on 2017/9/19.
 */
@Setter@Getter
public class BaseAudit {
    /***
     * 认证的三个状态
     */
    public static final byte STATE_NORMAL = 0;
    public static final byte STATE_PASS = 1;
    public static final byte STATE_REJECT = 2;
    public String getStateDisplay(){
        if(state==STATE_NORMAL){
            return "待审核";
        }else if(state==STATE_PASS){
            return "通过审核";
        }else{
            return "残忍拒绝";
        }
    }
    protected Byte state;

    protected String remark;

    protected Date auditTime;

    protected Date applyTime;
    
    protected long au_id;

    protected String au_username;

    protected long ap_id;

    protected String ap_username;

}

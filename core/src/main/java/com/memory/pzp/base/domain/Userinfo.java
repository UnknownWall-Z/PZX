package com.memory.pzp.base.domain;

import com.memory.pzp.base.util.BitStatesUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Userinfo {
    private Long id;

    private Integer version;

    private Long bitState;

    private String realName;

    private String idNumber;

    private String phoneNumber;

    private String email;

    private int score;

    private Long realAuthId;

    private SystemdictionaryItem incomeGrade;

    private SystemdictionaryItem marriage;

    private SystemdictionaryItem kidCount;

    private SystemdictionaryItem educationBackground;

    private SystemdictionaryItem houseCondition;

    public boolean getHasBindPhone(){
        return BitStatesUtils.hasState(bitState,BitStatesUtils.OP_BIND_PHONE);
    }
    public boolean getHasBindEmail(){
        return BitStatesUtils.hasState(bitState,BitStatesUtils.OP_BIND_EMAIL);
    }
    public boolean getHasBasicInfo(){ return BitStatesUtils.hasState(bitState,BitStatesUtils.OP_BIND_BASIC);}
    public boolean getHasRealAuth(){ return BitStatesUtils.hasState(bitState,BitStatesUtils.OP_BIND_REALAUTH);}
    public boolean getHasVedioAuth(){ return BitStatesUtils.hasState(bitState,BitStatesUtils.OP_BIND_VEDIOAUTH);}
    public boolean getHasBidRequest(){ return BitStatesUtils.hasState(bitState,BitStatesUtils.HAS_BIDREQUEST_IN_PROCESS);}
}
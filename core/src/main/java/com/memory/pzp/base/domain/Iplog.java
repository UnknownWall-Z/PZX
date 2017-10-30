package com.memory.pzp.base.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter@Getter@ToString
public class Iplog {

    public static final byte LOGIN_NORMAL = 1;
    public static final byte LOGIN_ABNORMAL = 0;

    private Long id;

    private String ip;

    private Byte state;

    private String username;

    private String userType;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date loginTime;

    public String getStateDisplay(){
        return state==LOGIN_NORMAL?"正常登陆":"非正常登陆";
    }

}
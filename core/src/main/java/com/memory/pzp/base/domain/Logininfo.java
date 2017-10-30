package com.memory.pzp.base.domain;

import lombok.ToString;

/**
 * Created by wall on 2017/9/12.
 */
@lombok.Setter
@lombok.Getter
@ToString
public class Logininfo {

    public static final int STATE_NORMAL = 0;//正常状态
    public static final int STATE_LOCK = 1;//锁定状态
    public static final byte COMMON = 0;
    public static final byte MANAGER = 1;

    private Long id;
    private String username;
    private String password;
    private int state;
    private byte userType;

}

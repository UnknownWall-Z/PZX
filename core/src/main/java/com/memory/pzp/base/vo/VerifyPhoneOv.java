package com.memory.pzp.base.vo;

import lombok.*;

import java.util.Date;

/**
 * Created by wall on 2017/9/15.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter@ToString
public class VerifyPhoneOv {

    private String phoneName;
    private Date verifyDate;
    private long userId;
    private String uuid;
}

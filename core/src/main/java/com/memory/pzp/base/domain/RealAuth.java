package com.memory.pzp.base.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter@Getter@ToString
public class RealAuth extends BaseAudit{

    /**
     * 性别
     */
    public static final int MALE = 0;
    public static final int FEMALE = 1;


    private Long id;

    private String realname;

    private Byte sex;

    private String birthDate;

    private String idNumber;

    private String address;

    private String image1;

    private String image2;

    public String getSexDisplay(){
        return sex==MALE?"男":"女";
    }

}
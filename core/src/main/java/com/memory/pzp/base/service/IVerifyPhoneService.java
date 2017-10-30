package com.memory.pzp.base.service;

import com.memory.pzp.base.vo.VerifyPhoneOv;

/**
 * Created by wall on 2017/9/15.
 */
public interface IVerifyPhoneService {

    VerifyPhoneOv verifyPhone(VerifyPhoneOv verify,String phoneName,long id);

    boolean bindPhone(VerifyPhoneOv verfiyCode, String phoneNumber, String verifyCode);

    void sendEmail(String email, long userId) throws Exception;

    void verifyEmail(String verifyUrl);
}

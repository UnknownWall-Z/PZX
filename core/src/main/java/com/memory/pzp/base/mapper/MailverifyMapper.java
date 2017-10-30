package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.Mailverify;

public interface MailverifyMapper {

    int insert(Mailverify record);

    Mailverify selectByRandomCode(String verifyUrl);

}
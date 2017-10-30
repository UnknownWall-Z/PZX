package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.Account;
import java.util.List;

public interface AccountMapper {

    int insert(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Account record);

}
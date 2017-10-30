package com.memory.pzp.exp.mapper;

import com.memory.pzp.exp.domain.ExpAccount;
import java.util.List;

public interface ExpAccountMapper {

    int insert(ExpAccount record);

    ExpAccount selectByPrimaryKey(Long id);

    List<ExpAccount> selectAll();

    int updateByPrimaryKey(ExpAccount record);
}
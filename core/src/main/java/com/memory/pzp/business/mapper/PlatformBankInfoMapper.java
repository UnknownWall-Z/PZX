package com.memory.pzp.business.mapper;

import com.memory.pzp.base.query.PlatformBankInfoQueryObject;
import com.memory.pzp.business.domain.PlatformBankInfo;
import java.util.List;

public interface PlatformBankInfoMapper {

    int insert(PlatformBankInfo record);

    PlatformBankInfo selectByPrimaryKey(Long id);

    List<PlatformBankInfo> selectAll();

    int updateByPrimaryKey(PlatformBankInfo record);

    int count(PlatformBankInfoQueryObject qo);

    java.util.List<PlatformBankInfo> listData(PlatformBankInfoQueryObject qo);
}
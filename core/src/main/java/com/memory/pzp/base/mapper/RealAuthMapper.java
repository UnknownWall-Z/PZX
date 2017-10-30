package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.RealAuth;
import com.memory.pzp.base.query.RealAuthQueryObject;

import java.util.List;

public interface RealAuthMapper {

    int insert(RealAuth record);

    RealAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKey(RealAuth record);

    int count(RealAuthQueryObject qo);

    java.util.List<RealAuth> listData(RealAuthQueryObject qo);
}
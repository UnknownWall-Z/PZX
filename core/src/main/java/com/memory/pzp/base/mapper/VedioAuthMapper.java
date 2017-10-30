package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.VedioAuth;
import com.memory.pzp.base.query.VedioAuthQueryObject;

public interface VedioAuthMapper {

    int insert(VedioAuth record);

    VedioAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKey(VedioAuth record);

    int count(VedioAuthQueryObject qo);

    java.util.List<VedioAuth> listData(VedioAuthQueryObject qo);

}
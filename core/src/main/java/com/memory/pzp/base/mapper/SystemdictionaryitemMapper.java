package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.SystemdictionaryItem;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemdictionaryitemMapper {

    int insert(SystemdictionaryItem record);

    SystemdictionaryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKey(SystemdictionaryItem record);

    int count(SystemDictionaryQueryObject qo);

    java.util.List<SystemdictionaryItem>listData(SystemDictionaryQueryObject qo);

    List<SystemdictionaryItem> getItemsBySdId(long sdId);
}
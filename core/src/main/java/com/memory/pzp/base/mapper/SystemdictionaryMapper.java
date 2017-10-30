package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.Systemdictionary;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemdictionaryMapper {

    int insert(Systemdictionary record);

    Systemdictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Systemdictionary record);

    int count(SystemDictionaryQueryObject qo);

    List<Systemdictionary> listData(SystemDictionaryQueryObject qo);

    java.util.List<Systemdictionary> selectAll();
}
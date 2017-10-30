package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.Iplog;
import com.memory.pzp.base.query.IplogQueryObject;

import java.util.List;

public interface IplogMapper {

    int insert(Iplog record);

    int count(IplogQueryObject qo);

    List<Iplog> listData(IplogQueryObject qo);

}
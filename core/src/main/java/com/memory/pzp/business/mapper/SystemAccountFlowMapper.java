package com.memory.pzp.business.mapper;

import com.memory.pzp.business.domain.SystemAccountFlow;
import java.util.List;

public interface SystemAccountFlowMapper {

    int insert(SystemAccountFlow record);

    SystemAccountFlow selectByPrimaryKey(Long id);

    List<SystemAccountFlow> selectAll();

}
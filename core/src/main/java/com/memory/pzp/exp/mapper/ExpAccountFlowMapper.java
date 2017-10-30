package com.memory.pzp.exp.mapper;

import com.memory.pzp.exp.domain.ExpAccountFlow;
import java.util.List;

public interface ExpAccountFlowMapper {

    int insert(ExpAccountFlow record);

    ExpAccountFlow selectByPrimaryKey(Long id);

    List<ExpAccountFlow> selectAll();

    int updateByPrimaryKey(ExpAccountFlow record);
}
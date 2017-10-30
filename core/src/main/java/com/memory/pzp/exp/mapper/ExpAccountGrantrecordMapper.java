package com.memory.pzp.exp.mapper;

import com.memory.pzp.exp.domain.ExpAccountGrantrecord;
import java.util.List;

public interface ExpAccountGrantrecordMapper {

    int insert(ExpAccountGrantrecord record);

    ExpAccountGrantrecord selectByPrimaryKey(Long id);

    List<ExpAccountGrantrecord> selectAll();

    int updateByPrimaryKey(ExpAccountGrantrecord record);
}
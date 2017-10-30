package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.Userinfo;
import java.util.List;

public interface UserinfoMapper {

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Userinfo record);
}
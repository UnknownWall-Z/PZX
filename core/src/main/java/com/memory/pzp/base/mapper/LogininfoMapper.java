package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.Logininfo;
import org.apache.ibatis.annotations.Param;

public interface LogininfoMapper {

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Logininfo record);

    int checkUsernameExist(String username);

    Logininfo userLogin(@Param("username")String username,
                        @Param("password")String password,
                        @Param("userType")byte userType);

    Integer getUser(String username);

}
package com.memory.pzp.base.mapper;

import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.query.RealAuthQueryObject;
import com.memory.pzp.base.query.UserFilesQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserfileMapper {

    int insert(UserFile record);

    UserFile selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserFile record);

    List<UserFile> listFile(@Param("askId") Long askId,@Param("isNull") boolean isNull);

    int count(UserFilesQueryObject qo);

    java.util.List<UserFile> listData(UserFilesQueryObject qo);

    UserFile getUserFile(long uid);
}
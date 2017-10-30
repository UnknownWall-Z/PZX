package com.memory.pzp.business.mapper;

import com.memory.pzp.base.query.RechargeOfflineQueryObject;
import com.memory.pzp.business.domain.RechargeOffline;
import java.util.List;

public interface RechargeOfflineMapper {

    int insert(RechargeOffline record);

    RechargeOffline selectByPrimaryKey(Long id);

    List<RechargeOffline> selectAll();

    int updateByPrimaryKey(RechargeOffline record);

    int count(RechargeOfflineQueryObject qo);

    List<RechargeOffline> listData(RechargeOfflineQueryObject qo);
}
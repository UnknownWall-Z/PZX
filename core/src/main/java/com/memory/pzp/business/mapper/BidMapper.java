package com.memory.pzp.business.mapper;

import com.memory.pzp.business.domain.Bid;
import org.apache.ibatis.annotations.Param;

public interface BidMapper {

    int insert(Bid record);

    Bid selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Bid record);

    java.util.List<Bid> listByRequestId(long id);

    void updateStates(@Param("bidRequestState")int bidRequestState,
                      @Param("bidRquestId")long bidRquestId);
}
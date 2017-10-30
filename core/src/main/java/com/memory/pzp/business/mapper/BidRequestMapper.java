package com.memory.pzp.business.mapper;

import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.business.domain.BidRequest;
import java.util.List;

public interface BidRequestMapper {

    int insert(BidRequest record);

    BidRequest selectByPrimaryKey(Long id);

    int updateByPrimaryKey(BidRequest record);

    int count(BidRequestQueryObject qo);

    java.util.List<BidRequest> listData(BidRequestQueryObject qo);

    int countAudit(BidRequestQueryObject qo);

    java.util.List<BidRequest> auditData(BidRequestQueryObject qo);

}
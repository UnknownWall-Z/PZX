package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Iplog;
import com.memory.pzp.base.mapper.IplogMapper;
import com.memory.pzp.base.query.IplogQueryObject;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.service.IIplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wall on 2017/9/15.
 */
@Service
public class IplogServiceImpl implements IIplogService {

    @Autowired
    private IplogMapper iplogMapper;

    @Override
    public PageResult query(IplogQueryObject qo) {

        int count = iplogMapper.count(qo);
        if(count==0){
            return PageResult.empty(qo.getPageSize());
        }
        List<Iplog> iplogs = iplogMapper.listData(qo);

        return new PageResult(iplogs,count,qo.getCurrentPage(),qo.getPageSize());
    }
}

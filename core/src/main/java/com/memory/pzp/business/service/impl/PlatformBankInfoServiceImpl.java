package com.memory.pzp.business.service.impl;

import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.PlatformBankInfoQueryObject;
import com.memory.pzp.business.domain.PlatformBankInfo;
import com.memory.pzp.business.mapper.PlatformBankInfoMapper;
import com.memory.pzp.business.service.IPlatformBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wall on 2017/9/21.
 */
@Service
public class PlatformBankInfoServiceImpl implements IPlatformBankInfoService{

    @Autowired
    private PlatformBankInfoMapper platformBankInfoMapper;

    @Override
    public PageResult query(PlatformBankInfoQueryObject qo) {
        int count = platformBankInfoMapper.count(qo);
        if(count>0){
            List<PlatformBankInfo> listData = platformBankInfoMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    public void saveOrUpdate(PlatformBankInfo pb){
        if(pb.getId()!=null){
            platformBankInfoMapper.updateByPrimaryKey(pb);
        }else{
            platformBankInfoMapper.insert(pb);
        }
    }

    @Override
    public Object listAll() {
        return this.platformBankInfoMapper.selectAll();
    }
}

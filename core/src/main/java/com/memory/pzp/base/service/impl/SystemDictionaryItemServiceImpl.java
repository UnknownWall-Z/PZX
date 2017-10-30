package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.SystemdictionaryItem;
import com.memory.pzp.base.mapper.SystemdictionaryitemMapper;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;
import com.memory.pzp.base.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wall on 2017/9/16.
 */
@Service
public class SystemDictionaryItemServiceImpl implements ISystemDictionaryItemService{

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryItemMapper;

    @Override
    public PageResult query(SystemDictionaryQueryObject qo) {
        int count = systemdictionaryItemMapper.count(qo);
        if(count>0){
            java.util.List<SystemdictionaryItem> listData = systemdictionaryItemMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public void saveOrUpdate(SystemdictionaryItem sd) {

        if(sd.getId()==null){
            systemdictionaryItemMapper.insert(sd);
        }else{
            systemdictionaryItemMapper.updateByPrimaryKey(sd);
        }

    }

    @Override
    public SystemdictionaryItem get(long id) {
        return systemdictionaryItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemdictionaryItem> getItemsBySdId(long sdId) {
        return systemdictionaryItemMapper.getItemsBySdId(sdId);
    }

}

package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Systemdictionary;
import com.memory.pzp.base.mapper.SystemdictionaryMapper;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;
import com.memory.pzp.base.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wall on 2017/9/16.
 */
@Service
public class SystemDictionaryServiceImpl implements ISystemDictionaryService{

    @Autowired
    private SystemdictionaryMapper systemdictionaryMapper;

    @Override
    public PageResult query(SystemDictionaryQueryObject qo) {
        int count = systemdictionaryMapper.count(qo);
        if(count>0){
            java.util.List<Systemdictionary> listData = systemdictionaryMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public List<Systemdictionary> get() {
        return systemdictionaryMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(Systemdictionary sd) {

        if(sd.getId()==null){
            systemdictionaryMapper.insert(sd);
        }else{
            systemdictionaryMapper.updateByPrimaryKey(sd);
        }

    }

    @Override
    public Systemdictionary get(long id) {
        return systemdictionaryMapper.selectByPrimaryKey(id);
    }
}

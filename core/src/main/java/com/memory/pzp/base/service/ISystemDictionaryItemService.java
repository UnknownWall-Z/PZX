package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.SystemdictionaryItem;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;

import java.util.List;

/**
 * Created by wall on 2017/9/16.
 */
public interface ISystemDictionaryItemService {

    PageResult query(SystemDictionaryQueryObject qo);

    void saveOrUpdate(SystemdictionaryItem sd);

    SystemdictionaryItem get(long id);

    List<SystemdictionaryItem > getItemsBySdId(long sdId);
}

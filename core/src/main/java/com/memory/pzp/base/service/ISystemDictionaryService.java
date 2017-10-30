package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Systemdictionary;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;

/**
 * Created by wall on 2017/9/16.
 */
public interface ISystemDictionaryService {

    PageResult query(SystemDictionaryQueryObject qo);

    java.util.List<Systemdictionary> get();

    void saveOrUpdate(Systemdictionary sd);

    Systemdictionary get(long id);
}

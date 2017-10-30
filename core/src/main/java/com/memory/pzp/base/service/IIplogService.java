package com.memory.pzp.base.service;

import com.memory.pzp.base.query.IplogQueryObject;
import com.memory.pzp.base.query.PageResult;

/**
 * Created by wall on 2017/9/15.
 */
public interface IIplogService {

    PageResult query(IplogQueryObject qo);

}

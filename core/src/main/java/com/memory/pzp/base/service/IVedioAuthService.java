package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.VedioAuthQueryObject;

/**
 * Created by wall on 2017/9/19.
 */
public interface IVedioAuthService {

    PageResult query(VedioAuthQueryObject qo);

    Integer getUser(String username);

    void savaApply(int loginInfoValue, String remark,int state, long userId);
}

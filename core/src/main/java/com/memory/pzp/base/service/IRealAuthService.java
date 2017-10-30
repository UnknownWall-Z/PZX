package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.RealAuth;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.RealAuthQueryObject;

/**
 * Created by wall on 2017/9/17.
 */
public interface IRealAuthService {

    RealAuth get(Long id);

    /**
     * 用户填写的实名认证资料
     * @param logininfo
     * @param realAuth
     */
    void save(Logininfo logininfo, RealAuth realAuth);

    /**
     * 后台审核需要的数据列表
     * @param qo
     * @return
     */
    PageResult query(RealAuthQueryObject qo);

    void applyLook(long id, String remark, int state, Logininfo user);
}

package com.memory.pzp.business.service;

import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.PlatformBankInfoQueryObject;
import com.memory.pzp.business.domain.PlatformBankInfo;

/**
 * Created by wall on 2017/9/21.
 */
public interface IPlatformBankInfoService {
    PageResult query(PlatformBankInfoQueryObject qo);

    /***
     * 保存或更改银行
     * @param pb
     */
    void saveOrUpdate(PlatformBankInfo pb);

    /**
     * 所有添加的银行
     * @return
     */
    Object listAll();
}

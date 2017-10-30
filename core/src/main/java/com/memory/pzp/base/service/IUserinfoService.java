package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Userinfo;

/**
 * Created by wall on 2017/9/12.
 */
public interface IUserinfoService {

    int insert(long userId);

    /***
     *  加乐观锁
     * @param userinfo
     */
    void update(Userinfo userinfo);

    Userinfo getByUserId(Long id);

    void updateByUserId(Userinfo userinfo, Long userId);
}

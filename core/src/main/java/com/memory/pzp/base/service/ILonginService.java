package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Logininfo;

/**
 * Created by wall on 2017/9/12.
 */
public interface ILonginService {

    /***
     * 注册保存
     * @param username
     * @param password
     */
    void register(String username,String password);

    /***
     * 校验账号是否重复
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /***
     * 用户登入
     * @param username
     * @param password
     * @param addr
     * @param userType
     * @return
     */
    Logininfo userLogin(String username, String password,String addr,byte userType);

    Integer getUser(String username);
}

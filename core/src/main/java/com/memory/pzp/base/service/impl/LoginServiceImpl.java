package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Iplog;
import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.mapper.IplogMapper;
import com.memory.pzp.base.mapper.LogininfoMapper;
import com.memory.pzp.base.service.IAccountService;
import com.memory.pzp.base.service.ILonginService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.exp.service.IExpAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by wall on 2017/9/12.
 */
@Service
public class LoginServiceImpl implements ILonginService{

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IplogMapper iplogMapper;

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IExpAccountService expAccountService;


    @Override
    public void register(String username, String password) {
        Logininfo user = new Logininfo();
        user.setUsername(username);
        user.setPassword(password);
        logininfoMapper.insert(user);
        Long id = user.getId();
        accountService.insert(id);
        userinfoService.insert(id);
        expAccountService.insert(id);
    }

    @Override
    public boolean checkUsername(String username) {
        int count =  logininfoMapper.checkUsernameExist(username);
        if(count<=0){
            return true;
        }
        return false;
    }

    @Override
    public Logininfo userLogin(String username, String password,String addr,byte userType) {
        Logininfo logininfo = logininfoMapper.userLogin(username, password, userType);
        Iplog iplog = new Iplog();
        iplog.setUsername(username);
        iplog.setIp(addr);
        iplog.setLoginTime(new Date());
        switch (userType){
            case Iplog.LOGIN_ABNORMAL:iplog.setUserType("普通用户");break;
            case Iplog.LOGIN_NORMAL:iplog.setUserType("管理员");break;
        }
        if(null!=logininfo){
            iplog.setState(Iplog.LOGIN_NORMAL);
        }else{
            iplog.setState(Iplog.LOGIN_ABNORMAL);
        }
        iplogMapper.insert(iplog);
        return logininfo ;
    }

    @Override
    public Integer getUser(String username) {
        return this.logininfoMapper.getUser(username);
    }


}

package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.mapper.UserinfoMapper;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.util.BitStatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wall on 2017/9/12.
 */
@Service
@Transactional
public class UserinfoServiceImpl implements IUserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int insert(long userId) {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(userId);
        userinfo.setBitState(0L);
        return userinfoMapper.insert(userinfo);
    }

    @Override
    public void update(Userinfo userinfo) {

        int ret = userinfoMapper.updateByPrimaryKey(userinfo);
        if(ret<=0){
            throw new RuntimeException("乐观锁失败"+userinfo.getId());
        }

    }

    @Override
    public Userinfo getByUserId(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByUserId(Userinfo userinfo, Long userId) {
        Userinfo user= userinfoMapper.selectByPrimaryKey(userId);
        user.setEducationBackground(userinfo.getEducationBackground());
        user.setIncomeGrade(userinfo.getIncomeGrade());
        user.setMarriage(userinfo.getMarriage());
        user.setKidCount(userinfo.getKidCount());
        user.setHouseCondition(user.getHouseCondition());
        if(!user.getHasBasicInfo()){
            user.setBitState(BitStatesUtils.addState(user.getBitState(),BitStatesUtils.OP_BIND_BASIC));
        }
        userinfoMapper.updateByPrimaryKey(user);
    }
}

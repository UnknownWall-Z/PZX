package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.RealAuth;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.mapper.RealAuthMapper;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.RealAuthQueryObject;
import com.memory.pzp.base.service.IRealAuthService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.util.BitStatesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wall on 2017/9/17.
 */
@Service
public class RealAuthServiceImpl implements IRealAuthService{

    @Autowired
    private RealAuthMapper realAuthMapper;
    @Autowired
    private IUserinfoService userinfoService;

    @Override
    public RealAuth get(Long id) {
        return realAuthMapper.selectByPrimaryKey(id);
    }
    @Override
    public void save(Logininfo logininfo, RealAuth ra) {

        Long id = logininfo.getId();

        RealAuth r = new RealAuth();
        // 设置相关属性
        r.setAddress(ra.getAddress());
        r.setRealname(ra.getRealname());
        r.setAp_id(id);
        r.setApplyTime(new Date());
        r.setBirthDate(ra.getBirthDate());
        r.setIdNumber(ra.getIdNumber());
        r.setImage1(ra.getImage1());
        r.setImage2(ra.getImage2());
        r.setSex(ra.getSex());
        r.setState(RealAuth.STATE_NORMAL);
        realAuthMapper.insert(r);
        Userinfo userinfo = userinfoService.getByUserId(id);
        userinfo.setRealAuthId(r.getId());
        userinfoService.update(userinfo);
    }

    @Override
    public PageResult query(RealAuthQueryObject qo) {
        int count = realAuthMapper.count(qo);
        if(count>0){
            List<RealAuth> listData = realAuthMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public void applyLook(long id, String remark, int state, Logininfo user) {
        RealAuth realAuth = realAuthMapper.selectByPrimaryKey(id);
        realAuth.setState((byte)state);
        realAuth.setRemark(remark);
        realAuth.setAu_id(user.getId());
        realAuth.setAu_username(user.getUsername());
        realAuthMapper.updateByPrimaryKey(realAuth);
        Userinfo userAp = userinfoService.getByUserId(realAuth.getAp_id());
        if(state==RealAuth.STATE_PASS){
            userAp.setBitState(BitStatesUtils.addState(userAp.getBitState(),BitStatesUtils.OP_BIND_REALAUTH));
        }else{
            userAp.setRealAuthId(null);
        }
        userinfoService.update(userAp);
    }

}

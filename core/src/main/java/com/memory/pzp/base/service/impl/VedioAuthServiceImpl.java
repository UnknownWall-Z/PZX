package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.domain.VedioAuth;
import com.memory.pzp.base.mapper.VedioAuthMapper;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.VedioAuthQueryObject;
import com.memory.pzp.base.service.ILonginService;
import com.memory.pzp.base.service.IUserinfoService;
import com.memory.pzp.base.service.IVedioAuthService;
import com.memory.pzp.base.util.BitStatesUtils;
import com.memory.pzp.base.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wall on 2017/9/19.
 */
@Service
public class VedioAuthServiceImpl implements IVedioAuthService {

    @Autowired
    private VedioAuthMapper vedioAuthMapper;

    @Autowired
    private ILonginService longinService;

    @Autowired
    private IUserinfoService userinfoService;

    @Override
    public PageResult query(VedioAuthQueryObject qo) {
        int count = vedioAuthMapper.count(qo);
        if(count>0){
            List<VedioAuth> listData = vedioAuthMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public Integer getUser(String username) {
        return longinService.getUser(username);
    }

    @Override
    public void savaApply(int loginInfoValue, String remark,int state,long userId) {
        Userinfo user = userinfoService.getByUserId((long)loginInfoValue);
        if(!user.getHasVedioAuth()){
            VedioAuth vedioAuth = new VedioAuth();
            Logininfo logininfoZ = new Logininfo();
            logininfoZ.setId((long)loginInfoValue);
            vedioAuth.setApplier(logininfoZ);
            vedioAuth.setApplyTime(new Date());
            Logininfo logininfo = new Logininfo();
            logininfo.setId(userId);
            vedioAuth.setAuditor(logininfo);
            vedioAuth.setAuditTime(new Date());
            vedioAuth.setRemark(remark);
            vedioAuth.setState((byte)state);
            if(state== VedioAuth.STATE_PASS){
                user.setBitState(BitStatesUtils.addState(user.getBitState(),BitStatesUtils.OP_BIND_VEDIOAUTH));
                userinfoService.update(user);
            }
            this.vedioAuthMapper.insert(vedioAuth);

        }
    }
}

package com.memory.pzp.base.service.impl;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.SystemdictionaryItem;
import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.mapper.UserfileMapper;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.RealAuthQueryObject;
import com.memory.pzp.base.query.UserFilesQueryObject;
import com.memory.pzp.base.service.IUserFileService;
import com.memory.pzp.base.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wall on 2017/9/19.
 */
@Service
public class UserFileServiceImpl implements IUserFileService{

    @Autowired
    private UserfileMapper userFileMapper;

    @Autowired
    private IUserinfoService userinfoService;

    @Override
    public void apply(String fileName, Long id) {

        UserFile userFile = new UserFile();

        userFile.setFile(fileName);

        userFile.setState(UserFile.STATE_NORMAL);

        userFile.setApplyTime(new Date());

        userFile.setAp_id(id);

        userFileMapper.insert(userFile );
    }

    @Override
    public List<UserFile> listFile(Long askId, boolean isNull) {
        return userFileMapper.listFile(askId,isNull);
    }

    @Override
    public void choiceTypes(Long[] fileType, Long[] id) {
        for(int i = 0;i < id.length; i++){
            UserFile userFile = userFileMapper.selectByPrimaryKey(id[i]);
            SystemdictionaryItem sdi = new SystemdictionaryItem();
            sdi.setId(fileType[i]);
            userFile.setFiletype(sdi);
            userFileMapper.updateByPrimaryKey(userFile);
        }
    }

    @Override
    public PageResult query(UserFilesQueryObject qo) {
        int count = userFileMapper.count(qo);
        if(count>0){
            List<UserFile> listData = userFileMapper.listData(qo);
            return new PageResult(listData,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public UserFile getUserFile(long uid) {
        return userFileMapper.getUserFile(uid);
    }

    @Override
    public void applyUserFile(long id, String remark, int score, int state, long userId) {
        UserFile userFile = this.userFileMapper.selectByPrimaryKey(id);
        if(userFile!=null && userFile.getFiletype()!=null && userFile.getState()== UserFile.STATE_NORMAL){
            userFile.setRemark(remark);
            userFile.setAu_id(userId);
            userFile.setAuditTime(new Date());
            if(state==UserFile.STATE_PASS){
                userFile.setScore((byte)score);
                Userinfo user = userinfoService.getByUserId(userFile.getAp_id());
                user.setScore(user.getScore()+score);
                userinfoService.update(user);
            }else{
                userFile.setScore((byte)0);

            }
            userFile.setState((byte)state);
            userFileMapper.updateByPrimaryKey(userFile);
        }
    }

    @Override
    public List<UserFile> listByState(UserFilesQueryObject qo) {
        return userFileMapper.listData(qo);
    }
}

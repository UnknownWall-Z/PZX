package com.memory.pzp.base.service;

import com.memory.pzp.base.domain.Logininfo;
import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.UserFilesQueryObject;

import java.util.List;

/**
 * Created by wall on 2017/9/19.
 */
public interface IUserFileService {

    /***
     * 保存无类型图片
     * @param fileName
     * @param id
     */
    void apply(String fileName, Long id);

    /***
     * 根据申请人查材料
     * @param askId
     * @param b
     * @return
     */
    List<UserFile> listFile(Long askId, boolean b);

    /***
     * 保存多个风控材料
     * @param fileType
     * @param id
     */
    void choiceTypes(Long[] fileType, Long[] id);

    PageResult query(UserFilesQueryObject qo);

    /**
     * 回显该条风控材料数据
     * @param uid
     * @return
     */
    UserFile getUserFile(long uid);

    /***
     * 存储审核风控材料
     * @param id
     * @param remark
     * @param score
     * @param state
     * @param userId
     */
    void applyUserFile(long id, String remark, int score, int state, long userId);
    /***
     * 无分页查询所有审核材料
     */
    java.util.List<UserFile> listByState(UserFilesQueryObject qo);
}

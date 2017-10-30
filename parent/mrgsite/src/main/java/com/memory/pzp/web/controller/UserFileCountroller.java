package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.query.RealAuthQueryObject;
import com.memory.pzp.base.query.UserFilesQueryObject;
import com.memory.pzp.base.service.IUserFileService;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/19.
 */

/***
 * 风控材料后台审核页面
 */
@Controller
public class UserFileCountroller {

    @Autowired
    private IUserFileService userFileService;

    @RequestMapping("userFileAuth")
    public String userFileAuth(@ModelAttribute("qo")UserFilesQueryObject qo, Model model){
        model.addAttribute("pageResult",userFileService.query(qo));
        return "list";
    }

    @RequestMapping("getUserFile")
    @ResponseBody
    public UserFile getUserFile(long uid ){
        return userFileService.getUserFile(uid);
    }

    @RequestMapping("userFile_audit")
    @ResponseBody
    public ResultAjax userFile_audit(long id,String remark,int score,int state){
        userFileService.applyUserFile(id,remark,score,state, UserContext.getCurrent().getId());
        return new ResultAjax();
    }
}

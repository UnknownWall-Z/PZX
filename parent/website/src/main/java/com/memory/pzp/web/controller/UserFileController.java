package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.UserFile;
import com.memory.pzp.base.service.ISystemDictionaryItemService;
import com.memory.pzp.base.service.IUserFileService;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.util.UploadUtil;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by wall on 2017/9/19.
 */

/***
 * 风控材料页面控制
 */
@Controller
public class UserFileController {

    @Autowired
    private IUserFileService userFileService;

    @Autowired
    private ISystemDictionaryItemService dicService;

    @RequestMapping("userFile")
    public String userFile(Model model){
//        model.addAttribute("askId",askId);
        Long askId = UserContext.getCurrent().getId();

        java.util.List<UserFile> userFiles = userFileService.listFile(askId,true);
        if(userFiles.size()>0){
            model.addAttribute("userFiles",userFiles);
            model.addAttribute("fileTypes",dicService.getItemsBySdId(7));
            return "userFiles_commit";
        }
        model.addAttribute("userFiles",userFileService.listFile(askId,false));
        return "userFiles";
    }

    /***
     * 上传图片url
     * @param file
     * @return
     */
    @RequestMapping("applyUserFile")
    @ResponseBody
    public String applyUserFile(MultipartFile file){
        String fileName = UploadUtil.upload(file, Consts.PUBLIC_PATH);
        userFileService.apply(fileName,UserContext.getCurrent().getId());
        return fileName;
    }
    /**
     * 提交风控材料类型
     */
    @RequestMapping("userFile_selectType")
    @ResponseBody
    public ResultAjax choiceTypes(Long[] fileType, Long[] id) {
        this.userFileService.choiceTypes(fileType, id);
        return new ResultAjax();
    }

}

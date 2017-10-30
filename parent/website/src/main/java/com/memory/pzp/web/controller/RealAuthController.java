package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.RealAuth;
import com.memory.pzp.base.domain.Userinfo;
import com.memory.pzp.base.service.IRealAuthService;
import com.memory.pzp.base.service.IUserinfoService;
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

/**
 * Created by wall on 2017/9/17.
 */
/***
 * 实名认证前台处理
 */
@Controller
public class RealAuthController {

    @Autowired
    private IRealAuthService realAuthService;
    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping("realAuth")
    public String realAuth(Model model){
        Long id = UserContext.getCurrent().getId();
        Userinfo user = userinfoService.getByUserId(id);
        if(user.getHasRealAuth()) {
            model.addAttribute("auditing",false);
            model.addAttribute("realAuth",realAuthService.get(user.getRealAuthId()));
            return "realAuth_result";
        }
        if(user.getRealAuthId()!=null){
            model.addAttribute("auditing",true);
            return "realAuth_result";
        }
        return "realAuth";
    }

    @RequestMapping("realAuth_save")
    @ResponseBody
    public ResultAjax realAuth_save(RealAuth realAuth){
        try{
            realAuthService.save(UserContext.getCurrent(),realAuth);
        }catch (Exception e){
            new ResultAjax("保存失败!");
        }
        return new ResultAjax();
    }

    @RequestMapping("uploadImage")
    @ResponseBody
    public String uploadImage(MultipartFile impage){
        System.out.println(impage.getOriginalFilename()+"------>");
        String upload = UploadUtil.upload(impage,Consts.PUBLIC_PATH);
        return upload;
    }
}

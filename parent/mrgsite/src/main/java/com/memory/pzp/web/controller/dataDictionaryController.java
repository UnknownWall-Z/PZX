package com.memory.pzp.web.controller;

import com.memory.pzp.base.domain.Systemdictionary;
import com.memory.pzp.base.domain.SystemdictionaryItem;
import com.memory.pzp.base.query.SystemDictionaryQueryObject;
import com.memory.pzp.base.service.ISystemDictionaryItemService;
import com.memory.pzp.base.service.ISystemDictionaryService;
import com.memory.pzp.base.util.ResultAjax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/9/16.
 */
@Controller
public class dataDictionaryController {

    @Autowired
    private ISystemDictionaryService systemDictionaryService;

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    /**
     * 数据字典列表
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("systemDictionary_list")
    public String systemDictionary(@ModelAttribute("qo")SystemDictionaryQueryObject qo, Model model){
        model.addAttribute("pageResult",systemDictionaryService.query(qo));
        return "systemdic/systemDictionary_list";
    }
    @RequestMapping("systemDictionary_update")
    @ResponseBody
    public ResultAjax saveOrUpdate(Systemdictionary sd){
        systemDictionaryService.saveOrUpdate(sd);
        return new ResultAjax();
    }
    @RequestMapping("displayData")
    @ResponseBody
    public Systemdictionary displayData(long sid){
        return systemDictionaryService.get(sid);
    }

    /***
     * 数据字典明细列表明显
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("systemDictionaryItem_list")
    public String systemDictionaryItem(@ModelAttribute("qo")SystemDictionaryQueryObject qo, Model model){
        model.addAttribute("systemDictionaryGroups",systemDictionaryService.get());
        model.addAttribute("pageResult",systemDictionaryItemService.query(qo));
        return "systemdic/systemDictionaryItem_list";
    }
    @RequestMapping("systemDictionaryItem_update")
    @ResponseBody
    public ResultAjax sdItemUpdate(SystemdictionaryItem sdItem){
       systemDictionaryItemService.saveOrUpdate(sdItem);
        return new ResultAjax();
    }
    @RequestMapping("displayDataItem")
    @ResponseBody
    public SystemdictionaryItem displayDataItem(long sid){
        return systemDictionaryItemService.get(sid);
    }
}

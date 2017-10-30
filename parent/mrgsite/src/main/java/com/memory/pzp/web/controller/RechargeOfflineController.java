package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.PageResult;
import com.memory.pzp.base.query.RechargeOfflineQueryObject;
import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.business.service.IPlatformBankInfoService;
import com.memory.pzp.business.service.IRechargeOfflineService;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 线下充值审核控制器
 * 
 * @author xmg
 *
 */
@Controller
public class RechargeOfflineController {

	@Autowired
	private IRechargeOfflineService rechargeOfflineService;
	
	@Autowired
	private IPlatformBankInfoService bankService;

	@RequestMapping("rechargeOffline")
	public String rechargeList(@ModelAttribute("qo") RechargeOfflineQueryObject qo, Model model) {
        model.addAttribute("pageResult",this.rechargeOfflineService.query(qo));
		model.addAttribute("banks",this.bankService.listAll());
		return "rechargeoffline/list";
	}

	@RequestMapping("rechargeOffline_audit")
	@ResponseBody
	public ResultAjax rechargAudit(long id,String remark,int state){
		rechargeOfflineService.rechargAudit(id,remark,state, UserContext.getCurrent());
		return new ResultAjax();
	}

}

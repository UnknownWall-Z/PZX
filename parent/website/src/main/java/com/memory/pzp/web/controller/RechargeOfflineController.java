package com.memory.pzp.web.controller;

import com.memory.pzp.base.util.ResultAjax;
import com.memory.pzp.business.domain.RechargeOffline;
import com.memory.pzp.business.service.IPlatformBankInfoService;
import com.memory.pzp.business.service.IRechargeOfflineService;
import com.memory.pzp.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 线下充值控制器
 * 
 * @author xmg
 *
 */
@Controller
public class RechargeOfflineController {
	
	@Autowired
	private IPlatformBankInfoService bankinfoService;
	
	@Autowired
	private IRechargeOfflineService rechargeService;

	/**
	 * 导向充值页面
	 */
	@RequestMapping("recharge")
	public String recharge(Model model) {
		model.addAttribute("banks",this.bankinfoService.listAll());
		return "recharge";
	}

	/**
	 * 线下充值申请
	 */
	@RequestMapping("recharge_save")
	@ResponseBody
	public ResultAjax rechargeApply(RechargeOffline ro){
		this.rechargeService.apply(ro, UserContext.getCurrent());
		return new ResultAjax();
	}
}

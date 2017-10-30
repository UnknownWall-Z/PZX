package com.memory.pzp.base.query;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RechargeOfflineQueryObject extends QueryObject {

	protected int state = -1;
	protected Date beginDate;
	protected Date endDate;
	private long bankInfoId = -1;
	private String tradeCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTradeCode() {
		return StringUtils.hasLength(tradeCode) ? tradeCode : null;
	}

}

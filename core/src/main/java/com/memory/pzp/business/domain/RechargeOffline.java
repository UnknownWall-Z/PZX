package com.memory.pzp.business.domain;

import com.alibaba.fastjson.JSON;
import com.memory.pzp.base.domain.ObjectAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Setter@Getter@ToString
public class RechargeOffline extends ObjectAudit{

    private Long id;

    private String tradeCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tradeTime;

    private BigDecimal amount;

    private String note;

    private PlatformBankInfo bankinfo;

    public String getJsonString() {
        Map<String, Object> json = new HashMap<>();
        json.put("id", id);
        json.put("username", this.applier.getUsername());
        json.put("tradeCode", tradeCode);
        json.put("amount", amount);
        json.put("tradeTime", DateFormat.getDateInstance().format(tradeTime));
        return JSON.toJSONString(json);
    }

}
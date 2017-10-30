package com.memory.pzp.business.domain;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Setter@Getter@ToString
public class PlatformBankInfo {

    private Long id;

    private String bankname;

    private String accountname;

    private String banknumber;

    private String bankforkname;

    public String getJsonString(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("bankname",bankname);
        map.put("accountname",accountname);
        map.put("banknumber",banknumber);
        map.put("bankforkname",bankforkname);
        return JSON.toJSONString(map);
    }

}
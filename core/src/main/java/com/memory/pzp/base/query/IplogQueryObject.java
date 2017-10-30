package com.memory.pzp.base.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by wall on 2017/9/15.
 */
@Setter@Getter@ToString
public class IplogQueryObject extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String username;
    private byte state=-1;
    private byte userType=-1;

    public String getUsername(){
        return "".equals(username)?null:username;
    }
}

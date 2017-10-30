package com.memory.pzp.base.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by wall on 2017/9/18.
 */
@Setter@Getter@ToString
public class RealAuthQueryObject extends QueryObject {

    private Byte state = -1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

}

package com.memory.pzp.base.query;

import com.memory.pzp.business.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by wall on 2017/9/20.
 */
@Setter@Getter@ToString
public class BidRequestQueryObject extends QueryObject {

    private byte state=-1;
    private byte bidRequestState = -1;
    private byte bidRequestType = -1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    public Date getEndDate() {
        return DateUtil.getEndDate(endDate);
    }
}

package com.memory.pzp.base.util;

import lombok.*;

/**
 * Created by wall on 2017/9/12.
 */
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultAjax {

    private boolean success=true;
    private String msg;

    public ResultAjax(String msg){
        success=false;
        this.msg=msg;
    }
}

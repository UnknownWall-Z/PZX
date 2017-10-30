package com.memory.pzp.base.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by wall on 2017/9/16.
 */
@Setter@Getter@ToString
public class SystemDictionaryQueryObject extends QueryObject{

    private String keyword;

    private Long parentId;

    public String getKeyword(){
        return keyword==""?null:keyword;
    }

}

package com.memory.pzp.base.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserFile extends BaseAudit{

    private Long id;

    private Byte score;

    private String file;

    private SystemdictionaryItem filetype;

}
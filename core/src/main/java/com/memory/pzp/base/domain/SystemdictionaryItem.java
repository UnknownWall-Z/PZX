package com.memory.pzp.base.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class SystemdictionaryItem {

    private Long id;

    private Long parentId;

    private String title;

    private Byte sequence;

}
package com.memory.pzp.base.domain;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter@ToString
public class Mailverify {

    private Long id;

    private Long userinfo_id;

    private Date deadline;

    private String randomcode;

    private String email;

}
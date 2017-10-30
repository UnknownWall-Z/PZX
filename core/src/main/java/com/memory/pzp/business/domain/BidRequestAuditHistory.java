package com.memory.pzp.business.domain;

import com.memory.pzp.base.domain.ObjectAudit;
import com.memory.pzp.base.util.Consts;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class BidRequestAuditHistory extends ObjectAudit{

    private Long id;

    private Long bidrequestId;

    private Byte auditType;

    public String getAuditTypeDisplay(){
        return Consts.getbidrequeststatedisplay(this.auditType);
    }
}
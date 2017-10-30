package com.memory.pzp.web.controller;

import com.memory.pzp.base.query.BidRequestQueryObject;
import com.memory.pzp.base.util.Consts;
import com.memory.pzp.business.domain.BidRequest;
import com.memory.pzp.business.service.IBidRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wall on 2017/9/21.
 */
@Controller
public class IndexController {

    @Autowired
    private IBidRequestService bidRequestService;

    @RequestMapping("index")
    public String index(Model model){
        BidRequestQueryObject qo = new BidRequestQueryObject();
        qo.setState((byte)Consts.BIDREQUEST_STATE_BIDDING);
        qo.setIsPaging(0);
        List<BidRequest> bidRequests = bidRequestService.bidding(qo);
        model.addAttribute("bidRequests",bidRequests);
        return "main";
    }

}

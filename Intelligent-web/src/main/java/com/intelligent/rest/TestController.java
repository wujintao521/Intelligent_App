package com.intelligent.rest;

import com.intelligent.basic.exception.ServiceException;
import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.entity.UserInfo;
import com.intelligent.entity.WzlBigdata;
import com.intelligent.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    final DemoService demoService;

    @GetMapping("/test")
    public ResponseMessage<List<UserInfo>> test() {
        if (1==1) {
            throw new ServiceException("错了");
        }
       return demoService.getUserInfo();
    }

    @GetMapping("/queryList")
    public ResponseMessage<List<WzlBigdata>> queryList() {
        return demoService.queryList();
    }

    @GetMapping("/queryCount")
    public ResponseMessage<Integer> queryCount() {
        return demoService.queryCount();
    }

}

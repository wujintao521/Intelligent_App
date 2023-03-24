package com.intelligent.rest;

import com.intelligent.entity.UserInfo;
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
    public List<UserInfo> test() {
       return demoService.getUserInfo();
    }

}

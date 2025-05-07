package com.intelligent.rest;

import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import com.intelligent.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    final DemoService demoService;

    @PostMapping("/test/user/login")
    public ResponseMessage test() {
        Map<String,String> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.success(map);
    }

    @GetMapping("/test/user/info")
    public ResponseMessage info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
        return Result.success(map);
    }

    @PostMapping("/test/user/logout")
    public ResponseMessage get() {
        return Result.success();
    }

    public static void main(String[] args) {

    }

}

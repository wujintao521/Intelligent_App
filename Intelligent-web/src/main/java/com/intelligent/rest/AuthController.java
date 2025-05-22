package com.intelligent.rest;

import com.alibaba.fastjson.JSONObject;
import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import com.intelligent.request.AuthRequest;
import com.intelligent.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    final AuthService authService;

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody String json) {
        log.info("登录参数：{}",json);
        AuthRequest request = JSONObject.parseObject(json, AuthRequest.class);
        ResponseMessage responseMessage = authService.login(request);
        return Result.success(responseMessage);
    }
}

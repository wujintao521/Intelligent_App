package com.intelligent.controller;

import com.commos.utils.Result;
import com.intelligent.request.PersonRequest;
import com.intelligent.service.IUserInfoService;
import com.intelligent.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user/login")
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @PostMapping("/browsUserInfo")
    public Result<List<UserInfoVO>> browsUserInfo(@RequestBody PersonRequest request){
        //调试
        return Result.buildResult(Result.Status.OK, iUserInfoService.browsUserInfo(request));
    }

    @PostMapping("/updateUserInfo")
    public Boolean updateUserInfo(@RequestBody PersonRequest request){
        return iUserInfoService.updateUserInfo(request);
    }

}

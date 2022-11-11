package com.intelligent.controller;

import com.commos.utils.Result;
import com.intelligent.request.PersonRequest;
import com.intelligent.service.IUserInfoService;
import com.intelligent.vo.UserInfoVO;
import com.model.dto.PmsCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class UserInfoController {

    final IUserInfoService iUserInfoService;

    @PostMapping("/browsUserInfo")
    public Result<List<UserInfoVO>> browsUserInfo(@RequestBody PersonRequest request){
        return Result.buildResult(Result.Status.OK, iUserInfoService.browsUserInfo(request));
    }

    @PostMapping("/updateUserInfo")
    public Result<Boolean> updateUserInfo(@RequestBody PersonRequest request){
        return Result.buildResult(Result.Status.OK,iUserInfoService.updateUserInfo(request));
    }

    @PostMapping("/insertUserInfo")
    public Result<Boolean> insertUserInfo(@RequestBody PersonRequest request){
        return Result.buildResult(Result.Status.OK,iUserInfoService.insertUserInfo(request));
    }

    @PostMapping("/getPmsCateGoryInfo")
    public Result<List<PmsCategory>> getPmsCateGoryInfo (@RequestBody PmsCategory pmsCategory) {
        return Result.buildResult(Result.Status.OK,iUserInfoService.getPmsCategoryInfo(pmsCategory));
    }

    @PostMapping("/getPmsCategoryNode")
    public Result<List<PmsCategory>> getPmsCategoryNode() {
        return Result.buildResult(Result.Status.OK,iUserInfoService.getPmsCategoryNode());
    }

    @PostMapping("/getPmsCategoryTree")
    public Result<List<PmsCategory>> getPmsCategoryTree() {
        return Result.buildResult(Result.Status.OK,iUserInfoService.getPmsCategoryTree());
    }

}

package com.intelligent.service.impl;

import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import com.intelligent.dao.UserInfoMapper;
import com.intelligent.entity.UserInfo;
import com.intelligent.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {

    final UserInfoMapper userInfoMapper;

    @Override
    public ResponseMessage<List<UserInfo>> getUserInfo() {
        List<UserInfo> userInfos = userInfoMapper.selectUserInfo();
        return Result.success("success",userInfos);
    }

}

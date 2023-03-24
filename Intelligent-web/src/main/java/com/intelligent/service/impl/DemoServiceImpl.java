package com.intelligent.service.impl;

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
    public List<UserInfo> getUserInfo() {
        List<UserInfo> userInfos = userInfoMapper.selectUserInfo();
        return userInfos;
    }

}

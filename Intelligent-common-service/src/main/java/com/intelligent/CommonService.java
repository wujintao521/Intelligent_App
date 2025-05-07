package com.intelligent;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.intelligent.dao.UserInfoMapper;
import com.intelligent.entity.Test;
import com.intelligent.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonService {
    final UserInfoMapper userInfoMapper;

    public UserInfo buildUserInfo () {
        UserInfo info = new UserInfo();
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey("111");
        if (Objects.isNull(userInfo1)) {
            log.info("会回滚么");
        }
        info.setUid(IdWorker.getIdStr());
        info.setDeleted("0");
        info.setModifytime(userInfo1.getModifytime());
        return info;
    }

    public Test buildTest () {
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey("111");
        Test test = new Test();
        test.setId(IdWorker.getIdStr());
        test.setName(userInfo1.getUsername());
        return test;
    }
}

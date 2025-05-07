package com.intelligent;

import com.intelligent.dao.TestMapper;
import com.intelligent.dao.UserInfoMapper;
import com.intelligent.entity.Test;
import com.intelligent.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransionalService {

    final TestMapper testMapper;
    final UserInfoMapper userInfoMapper;

    //@Transactional(rollbackFor = Exception.class)
    public void dataProcessing(Test test){
        testMapper.insert(test);
        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey("111");
        userInfo1.getModifytime();
      /*  for (int i=0; i<=1;i++) {
            Test test2 =  service.buildTest();
            testMapper.insert(test2);
        }*/
    }
}

package com.intelligent.service.impl;

import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import com.intelligent.dao.UserInfoMapper;
import com.intelligent.dao.WzlBigdataMapper;
import com.intelligent.entity.UserInfo;
import com.intelligent.entity.WzlBigdata;
import com.intelligent.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {

    final UserInfoMapper userInfoMapper;
    final WzlBigdataMapper wzlBigdataMapper;

    @Override
    public ResponseMessage<List<UserInfo>> getUserInfo() {
        List<UserInfo> userInfos = userInfoMapper.selectUserInfo();
        return Result.success("success",userInfos);
    }

    @Override
    public ResponseMessage<List<WzlBigdata>> queryList() {
        List<WzlBigdata> wzlBigdata = wzlBigdataMapper.selectList();
        return Result.success("success",wzlBigdata);
    }

    @Override
    public ResponseMessage<Integer> queryCount() {
        Integer count = wzlBigdataMapper.selectCount();
        return Result.success("success",count);
    }


    public static void main(String[] args) {
        String message = "";
        try{
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        }catch(Exception e){
            message = String.valueOf(e);
            System.out.println("Exception thrown  :" + String.valueOf(e));
        }
        System.out.println("打印一下"+message);
    }
}

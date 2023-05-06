package com.intelligent.service;

import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.entity.UserInfo;
import com.intelligent.entity.WzlBigdata;


import java.util.List;

public interface DemoService {

    ResponseMessage<List<UserInfo>> getUserInfo();

    ResponseMessage<List<WzlBigdata>> queryList();

    ResponseMessage<Integer> queryCount();
}

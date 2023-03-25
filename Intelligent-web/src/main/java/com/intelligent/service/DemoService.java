package com.intelligent.service;

import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.entity.UserInfo;


import java.util.List;

public interface DemoService {

    ResponseMessage<List<UserInfo>> getUserInfo();

}

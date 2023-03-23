package com.intelligent.service;

import com.intelligent.entity.UserInfo;
import com.intelligent.basic.result.ResponseMessage;

import java.util.List;

public interface DemoService {

    ResponseMessage<List<UserInfo>> selectUserInfo();

}

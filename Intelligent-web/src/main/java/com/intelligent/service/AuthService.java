package com.intelligent.service;

import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.request.AuthRequest;

public interface AuthService {

    ResponseMessage  login(AuthRequest request);

}

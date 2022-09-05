package com.intelligent.service.impl;

import com.mapper.UserInfoMapper;
import model.dto.UserInfoDO;
import com.intelligent.request.PersonRequest;
import com.intelligent.service.IUserInfoService;
import com.intelligent.vo.UserInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-01-04
 */
@Service
public class UserInfoServiceImpl  implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoVO> browsUserInfo(PersonRequest request) {
        List<UserInfoVO> UserInfoVoList = new ArrayList<>();
        UserInfoVO userInfoVO = new UserInfoVO();
        UserInfoDO userInfoDO =  userInfoMapper.selectById(1);
        userInfoVO.setUserName(userInfoDO.getUserName());
        userInfoVO.setPassWord(userInfoDO.getPassWord());
        UserInfoVoList.add(userInfoVO);
        return UserInfoVoList;
    }

    public boolean updateUserInfo(PersonRequest request) {
        UserInfoDO userInfoDO =  userInfoMapper.selectById(1);
        userInfoDO.setUserName("fred");
        return userInfoMapper.updateById(userInfoDO)>0;
    }

    public boolean insertUserInfo(PersonRequest request) {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUId("1002");
        userInfoDO.setUserName("wjt");
        userInfoMapper.insert(userInfoDO);
        return true;
    }
}

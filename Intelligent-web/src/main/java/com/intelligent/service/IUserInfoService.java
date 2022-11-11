package com.intelligent.service;

import com.intelligent.request.PersonRequest;
import com.intelligent.vo.UserInfoVO;
import com.model.dto.PmsCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-01-04
 */
public interface IUserInfoService {

    List<UserInfoVO> browsUserInfo(PersonRequest request);

    boolean updateUserInfo(PersonRequest request);

    boolean insertUserInfo(PersonRequest request);

    List<PmsCategory> getPmsCategoryInfo(PmsCategory pmsCategory);

    List<PmsCategory> getPmsCategoryNode();

    List<PmsCategory> getPmsCategoryTree();
}

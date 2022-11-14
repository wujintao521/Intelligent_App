package com.intelligent.service.impl;

import com.intelligent.request.PersonRequest;
import com.intelligent.service.IUserInfoService;
import com.intelligent.mapper.PmsCategoryMapper;
import com.intelligent.mapper.UserInfoMapper;
import com.intelligent.mapper.PmsCategory;
import com.intelligent.mapper.UserInfoDO;
import com.vo.UserInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    @Override
    public List<UserInfoVO> browsUserInfo(PersonRequest request) {
        List<UserInfoVO> UserInfoVoList = new ArrayList<>();
        UserInfoVO userInfoVO = new UserInfoVO();
        UserInfoDO userInfoDO =  userInfoMapper.selectById(1001);
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

    public List<PmsCategory> getPmsCategoryInfo(PmsCategory pmsCategory) {
        return null;
    }

    public List<PmsCategory> getPmsCategoryNode() {
        List<PmsCategory> pmsCategories = pmsCategoryMapper.getPmsCategoryInfo(null);
        return pmsCategories.stream().filter( o -> o.getParentCid() == 0 ).peek(o -> o.setPmsCategoryNodes(getChildCategoryList(o, pmsCategories)))
                // 排序
                .sorted(Comparator.comparingInt(PmsCategory::getSort))
                // 收集
                .collect(Collectors.toList());
    }

    // 根据当前分类 找出子类， 并通过递归找出子类的子类
    private List<PmsCategory> getChildCategoryList(PmsCategory currMenu, List<PmsCategory> categories) {
        return categories.stream().filter(o -> o.getParentCid().equals(currMenu.getCatId()))
                .peek(o -> o.setPmsCategoryNodes(getChildCategoryList(o, categories)))
                .sorted(Comparator.comparingInt(PmsCategory::getSort))
                .collect(Collectors.toList());
    }

    public List<PmsCategory> getPmsCategoryTree() {
        List<PmsCategory> pmsCategories = pmsCategoryMapper.getPmsCategoryInfo(null);
        List<PmsCategory>  pmsCategoriesTree = new ArrayList<>();
        for (PmsCategory pmsCategory:pmsCategories) {
            PmsCategory tree = new PmsCategory();
            if(pmsCategory.getParentCid() == 0) {
                tree.setCatId(pmsCategory.getCatId());
                tree.setName(pmsCategory.getName());
                tree.setParentCid(pmsCategory.getParentCid());
                tree.setCatLevel(pmsCategory.getCatLevel());
                tree.setPmsCategoryNodes(getChildList(pmsCategories,pmsCategory.getCatId()));
                pmsCategoriesTree.add(tree);
            }
        }
        return pmsCategoriesTree;
    }

    public List<PmsCategory> getChildList(List<PmsCategory> pmsCategories ,Long id) {
        List<PmsCategory>  childList = new ArrayList<>();
        for (PmsCategory pmsCategory:pmsCategories) {
            PmsCategory node = new PmsCategory();
            if(pmsCategory.getParentCid().equals(id)) {
                node.setCatId(pmsCategory.getCatId());
                node.setName(pmsCategory.getName());
                node.setParentCid(pmsCategory.getParentCid());
                node.setCatLevel(pmsCategory.getCatLevel());
                node.setPmsCategoryNodes(getChildList(pmsCategories,pmsCategory.getCatId()));
                childList.add(node);
            }
        }
        return childList;
    }

}

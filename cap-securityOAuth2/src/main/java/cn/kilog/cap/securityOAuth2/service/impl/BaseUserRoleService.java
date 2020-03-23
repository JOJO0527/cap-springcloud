package cn.kilog.cap.securityOAuth2.service.impl;


import cn.kilog.cap.securityOAuth2.model.BaseUserRole;
import cn.kilog.cap.securityOAuth2.repository.BaseRepositoryImpl;
import cn.kilog.cap.securityOAuth2.utils.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by fp295 on 2018/4/9.
 */
@Service
public class BaseUserRoleService{
    @Autowired
    private BaseRepositoryImpl baseRepository;
    /**
     * 保存用户角色
     * @param baseUserRoleList
     */
    @Transactional
    public void saveUserRole(List<BaseUserRole> baseUserRoleList) {
        if (baseUserRoleList.size() > 0 && !StringUtils.isEmpty(baseUserRoleList.get(0).getRoleId())) {
            BaseUserRole userRole = new BaseUserRole();
            userRole.setUserId(baseUserRoleList.get(0).getUserId());
//            mapper.delete(userRole);
            baseRepository.deleteById(BaseUserRole.class,userRole.getId());
            baseUserRoleList.forEach(it -> {
                it.setId(UUID.uuid32());
//                insertSelective(it);
                baseRepository.save(it);
            });
        }
    }
}

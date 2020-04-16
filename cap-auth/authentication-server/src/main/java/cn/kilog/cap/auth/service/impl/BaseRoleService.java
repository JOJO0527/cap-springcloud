package cn.kilog.cap.auth.service.impl;

import cn.kilog.cap.auth.model.BaseRole;
import cn.kilog.cap.auth.model.BaseUserRole;
import cn.kilog.cap.auth.repository.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fp295 on 2018/4/9.
 */
@Service
public class BaseRoleService {
    @Autowired
    private BaseRepositoryImpl baseRepository;

    /**
     * 根据用户查询角色
     * 先根据userId找出对应的list<BaseUserRole>
     * 再根据baseUserRole中的roleId找出对应的list<BaseRole>
     */
    public List<BaseRole> getRoleByUserId(String userId) {
//        return ((BaseRoleMapper)mapper).getRoleByUserId(userId);
        List<BaseUserRole> baseUserRoles = baseRepository.findByField(BaseUserRole.class, "userId", userId);
        List<BaseRole> roles = new ArrayList<>(baseUserRoles.size());
        baseUserRoles.forEach(x ->
            roles.addAll(baseRepository.findByField(BaseRole.class, "id", x.getRoleId())));
        return roles.stream().distinct().collect(Collectors.toList());
    }
}

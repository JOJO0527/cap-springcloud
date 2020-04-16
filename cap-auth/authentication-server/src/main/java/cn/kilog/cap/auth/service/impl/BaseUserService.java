package cn.kilog.cap.auth.service.impl;

import cn.kilog.cap.auth.model.BaseUser;
import cn.kilog.cap.auth.model.BaseUserRole;
import cn.kilog.cap.auth.repository.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by fp295 on 2018/4/9.
 */
@Service
public class BaseUserService {

    @Autowired
    private BaseUserRoleService baseUserRoleService;
    @Autowired
    private BaseRepositoryImpl baseRepository;

    /**
     * 批量重置密码
     * @param record
     * @param newPassword
     */
    @Transactional
    public void resetPassword(List<BaseUser> record, String newPassword) {
        record.forEach(e -> {
            BaseUser baseUser = new BaseUser();
            baseUser.setId(e.getId());
            baseUser.setPassword(new BCryptPasswordEncoder(6).encode(newPassword));
            baseUser.setUpdateDate(new Date());
            baseRepository.update(BaseUser.class,e.getId());
//            updateByPrimaryKeySelective(baseUser);
        });
    }

    /**
     * 删除用户
     * @param record
     */
    @Transactional
    public void deleteBatch(List<BaseUser> record) {
        record.forEach(e -> {
//            Example example = new Example(BaseUserRole.class);
//            example.createCriteria().andEqualTo("userId", e.getId());
//            baseUserRoleService.deleteByExample(example);
//            deleteByPrimaryKey(e);
            baseRepository.deleteById(BaseUserRole.class,e.getId());
            baseRepository.delete(e);
        });
    }
}

package cn.kilog.cap.securityOAuth2.controller;

import cn.kilog.cap.securityOAuth2.model.BaseUser;

import cn.kilog.cap.securityOAuth2.model.BaseUserRole;
import cn.kilog.cap.securityOAuth2.pojo.ResponseCode;
import cn.kilog.cap.securityOAuth2.pojo.ResponseData;
import cn.kilog.cap.securityOAuth2.repository.BaseRepositoryImpl;
import cn.kilog.cap.securityOAuth2.utils.UUID;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private BaseRepositoryImpl baseRepository;
    @Autowired
    private BCryptPasswordEncoder  passwordEncoder;
    @PostMapping("/user")
    protected ResponseData<BaseUser> addRecord(@RequestBody BaseUser record) {
        log.debug("添加用户");
        try {
            log.debug("用户密码加密");
            record.setId(UUID.uuid32());
            record.setCreateDate(new Date());
            record.setPassword(passwordEncoder.encode(record.getPassword()));
//            baseUserService.insertSelective(record);
            baseRepository.save(record);
        } catch (Exception e) {
            log.error("添加用户失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }
    @PostMapping("/user/role")
    public ResponseData<BaseUser> saveUserRole(@RequestBody List<BaseUserRole> baseUserRoleList) {
        log.debug("保存用户授权角色");
        try {
//            baseUserRoleService.saveUserRole(baseUserRoleList);
            baseUserRoleList.forEach(
                    x->{
                        x.setId(UUID.uuid32());
                        baseRepository.save(x);
                    }
            );
        } catch (Exception e) {
            log.error("保存用户授权角色失败" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

}

package cn.kilog.cap.auth.controller;

import cn.kilog.cap.auth.model.BaseUser;
import cn.kilog.cap.auth.model.BaseUserRole;
import cn.kilog.cap.auth.pojo.HttpServletRequestAuthWrapper;
import cn.kilog.cap.auth.pojo.ResponseCode;
import cn.kilog.cap.auth.pojo.ResponseData;
import cn.kilog.cap.auth.repository.BaseRepositoryImpl;
import cn.kilog.cap.auth.service.IAuthenticationService;
import cn.kilog.cap.auth.utils.UUID;
import cn.kilog.cap.common.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    IAuthenticationService authenticationService;

    @PostMapping(value = "/permission")
    public ResponseResult decide(@RequestParam String url, @RequestParam String method, HttpServletRequest request) {
        boolean decide = authenticationService.decide(new HttpServletRequestAuthWrapper(request, url, method));
        return ResponseResult.ok(decide);
    }

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

    /**
     * 根据token获取用户信息
     * @param record
     * @return
     */
    @GetMapping("/user")
    protected ResponseData<BaseUser> getUser(@RequestBody BaseUser record) {
        log.debug("获取用户");
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
            baseUserRoleList.forEach(x -> {
                x.setId(UUID.uuid32());
                baseRepository.save(x);
            });
        } catch (Exception e) {
            log.error("保存用户授权角色失败" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

}

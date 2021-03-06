package cn.kilog.cap.auth.service.impl;


import cn.kilog.cap.auth.model.BaseUser;
import cn.kilog.cap.auth.repository.BaseRepositoryImpl;
import cn.kilog.cap.auth.service.BaseUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fp295 on 2018/11/25.
 */
@Service
public class UsernameUserDetailService extends BaseUserDetailService {
    @Autowired
    private BaseRepositoryImpl baseRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected BaseUser getUser(String username) {
        // 账号密码登陆调用FeignClient根据用户名查询用户
//        ResponseData<BaseUser> baseUserResponseData = baseUserService.getUserByUserName(username);
        BaseUser baseUserResponseData = (BaseUser)baseRepository.findByField(BaseUser.class, "username", username).get(0);
        return baseUserResponseData;
//        if(baseUserResponseData.getData() == null || !ResponseCode.SUCCESS.getCode().equals(baseUserResponseData.getCode())){
//            logger.error("找不到该用户，用户名：" + username);
//            throw new UsernameNotFoundException("找不到该用户，用户名：" + username);
//        }
//        return baseUserResponseData.getData();
    }
}

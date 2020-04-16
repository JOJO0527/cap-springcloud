package cn.kilog.cap.auth.controller;

import cn.kilog.cap.auth.model.OauthClientDetails;
import cn.kilog.cap.auth.pojo.ResponseCode;
import cn.kilog.cap.auth.pojo.ResponseData;
import cn.kilog.cap.auth.repository.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OauthClientDetailsController{


    @Autowired
    private BaseRepositoryImpl baseRepositoryl;

    @PostMapping("/client")
    protected ResponseData<OauthClientDetails> addRecord(@RequestBody OauthClientDetails record) {
        log.debug("添加客户端应用");
        try {
//            oauthClientDetailsService.insertSelective(record);
            record.setClientSecret(new BCryptPasswordEncoder().encode(record.getClientSecret()));
            baseRepositoryl.save(record);
        } catch (Exception e) {
            log.error("添加客户端应用失败：" + e.getMessage());
            e.printStackTrace();
            return new ResponseData<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
        }
        return new ResponseData<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }
}
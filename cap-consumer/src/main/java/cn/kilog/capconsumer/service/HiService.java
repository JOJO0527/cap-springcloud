package cn.kilog.capconsumer.service;

import cn.kilog.capconsumer.feign.ConsulClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    ConsulClientFeign consulClientFeign;

    public String sayHi(String name){
        return  consulClientFeign.sayHiFromClientConsul(name);
    }

}

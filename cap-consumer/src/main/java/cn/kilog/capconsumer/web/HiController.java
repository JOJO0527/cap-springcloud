package cn.kilog.capconsumer.web;

import cn.kilog.capconsumer.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @RequestMapping("/hi/{name}")
    public String sayHi(@PathVariable String name){
        return hiService.sayHi(name)+"aaa";
    }

}

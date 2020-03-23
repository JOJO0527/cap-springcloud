package cn.kilog.capprovider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class NormalController {

    @Value("${server.port}")
    String port;

    @Value("${username:lily}")
    private String username;

    @RequestMapping("/username")
    public String get() {
        return username;
    }

    @SentinelResource("hi")
    @RequestMapping("/hi/{name}")
    public String hi(@PathVariable("name") String name) {
        return  "hi " + name + ", i am from port  " + port + " myName is : " + username +"....";
    }



}

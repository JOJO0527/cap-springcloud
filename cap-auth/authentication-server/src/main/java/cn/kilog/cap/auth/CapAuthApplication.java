package cn.kilog.cap.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableDiscoveryClient
@EnableAuthorizationServer
@SpringBootApplication
@FeignClient
public class CapAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapAuthApplication.class, args);
    }

}

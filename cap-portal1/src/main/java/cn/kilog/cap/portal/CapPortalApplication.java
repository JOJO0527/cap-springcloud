package cn.kilog.cap.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "cn.kilog.cap.portal.service.remote")
public class CapPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapPortalApplication.class, args);
    }

}

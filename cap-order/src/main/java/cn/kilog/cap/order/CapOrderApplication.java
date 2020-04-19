package cn.kilog.cap.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "cn.kilog.cap.rest.client.*")
@SpringBootApplication
@EnableDiscoveryClient
public class CapOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapOrderApplication.class, args);
    }

}

package cn.kilog.cap.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.kilog.cap.rest.client.*")
@SpringBootApplication(scanBasePackages = {"cn.kilog.cap.manager","cn.kilog.cap.order"})
@MapperScan("cn.kilog.cap.manager")
public class CapOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapOrderApplication.class, args);
    }

}

package cn.kilog.cap.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.kilog.cap.manager"})
@MapperScan("cn.kilog.cap.manager")
public class CapManagerWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CapManagerWebApplication.class, args);
    }

}

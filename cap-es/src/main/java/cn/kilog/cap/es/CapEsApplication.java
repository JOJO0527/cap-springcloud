package cn.kilog.cap.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("cn.kilog.cap.es.mapper")
public class CapEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapEsApplication.class, args);    }
}

package cn.kilog.cap.securityOAuth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CapSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapSecurityApplication.class, args);
    }

}

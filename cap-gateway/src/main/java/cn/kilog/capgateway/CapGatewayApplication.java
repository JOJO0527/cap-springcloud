package cn.kilog.capgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CapGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapGatewayApplication.class, args);
    }

}

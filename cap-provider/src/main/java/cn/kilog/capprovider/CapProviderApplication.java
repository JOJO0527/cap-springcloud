package cn.kilog.capprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CapProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapProviderApplication.class, args);
    }

}

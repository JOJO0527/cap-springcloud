package cn.kilog.cap.mqprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({MySource.class})
public class CapMqproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapMqproviderApplication.class, args);
    }


}

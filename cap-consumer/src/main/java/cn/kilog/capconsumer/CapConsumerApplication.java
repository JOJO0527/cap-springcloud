package cn.kilog.capconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CapConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapConsumerApplication.class, args);
    }

}

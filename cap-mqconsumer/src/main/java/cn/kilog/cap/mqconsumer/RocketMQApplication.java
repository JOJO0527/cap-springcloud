package cn.kilog.cap.mqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({ MySink.class })
public class RocketMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQApplication.class, args);
    }

//    @Bean
//    public ConsumerCustomRunner customRunner() {
//        return new ConsumerCustomRunner();
//    }
}
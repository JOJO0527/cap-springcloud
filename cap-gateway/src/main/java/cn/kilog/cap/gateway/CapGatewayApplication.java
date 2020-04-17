package cn.kilog.cap.gateway;

import cn.kilog.cap.gateway.factory.RequestTimeGatewayFilterFactory;
import cn.kilog.cap.gateway.filter.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients(basePackages = "cn.kilog.cap.auth.provider")
@EnableDiscoveryClient
@SpringBootApplication
public class CapGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapGatewayApplication.class, args);
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }


    @Bean
    public AuthenticationFilter tokenFilter(){
        return new AuthenticationFilter();
    }
}

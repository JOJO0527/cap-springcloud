package cn.kilog.capconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  指定微服务名称，表示此feignClient只消费此服务
 */
@FeignClient("provider")
public interface ConsulClientFeign {

    @RequestMapping("/hi/{name}")
    String sayHiFromClientConsul(@PathVariable(value = "name") String name);
}

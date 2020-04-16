package cn.kilog.cap.auth.config;

import cn.kilog.cap.auth.model.BaseModuleResources;
import cn.kilog.cap.auth.model.BaseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Autowired
    private JedisConnectionFactory con;

    @Bean
    public RedisTemplate<String, BaseRole> baseRoleTemplate() {
        RedisTemplate<String, BaseRole> template = new RedisTemplate();
        template.setConnectionFactory(con);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    @Bean
    public RedisTemplate<String, BaseModuleResources> baseModelTemplate() {
        RedisTemplate<String, BaseModuleResources> template = new RedisTemplate();
        template.setConnectionFactory(con);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}

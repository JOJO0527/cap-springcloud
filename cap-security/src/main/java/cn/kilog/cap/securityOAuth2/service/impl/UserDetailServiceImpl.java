package cn.kilog.cap.securityOAuth2.service.impl;

import cn.kilog.cap.securityOAuth2.factory.JwtUserFactory;
import cn.kilog.cap.securityOAuth2.pojo.User;
import cn.kilog.cap.securityOAuth2.repository.UserRepository;
import cn.kilog.cap.securityOAuth2.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncode;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<Object, Object> objectObjectMap = redisUtils.hashGetAll(username);
        Set<Map.Entry<Object, Object>> entrySet = objectObjectMap.entrySet();
        HashMap<String, Object> hashMap = new HashMap<>();
        entrySet.forEach(x->hashMap.put(x.getKey().toString(),x.getValue()));
        User user = null;
        try {
             user = map2bean(hashMap, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == user) {
            log.info("username not found");
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }

    }


    //Map转换为JavaBean
    public static <T> T map2bean(Map<String,Object> map,Class<T> cl) throws Exception{
        //创建JavaBean对象
        T obj = cl.newInstance();
        //获取指定类的BeanInfo对象
        BeanInfo beanInfo = Introspector.getBeanInfo(cl, Object.class);
        //获取所有的属性描述器
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd:pds){
            Object value = map.get(pd.getName());
            Method setter = pd.getWriteMethod();
            if(value != ""){
                setter.invoke(obj, value);
            }
        }
        return  obj;
    }
}



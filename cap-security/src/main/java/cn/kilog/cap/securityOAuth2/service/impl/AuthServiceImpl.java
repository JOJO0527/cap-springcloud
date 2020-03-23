package cn.kilog.cap.securityOAuth2.service.impl;

import cn.kilog.cap.securityOAuth2.pojo.JwtUser;
import cn.kilog.cap.securityOAuth2.pojo.User;
import cn.kilog.cap.securityOAuth2.repository.UserRepository;
import cn.kilog.cap.securityOAuth2.service.AuthService;
import cn.kilog.cap.securityOAuth2.utils.JwtTokenUtil;
import cn.kilog.cap.securityOAuth2.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisUtils redisUtils;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

//    @Autowired
//    public AuthServiceImpl(
//            AuthenticationManager authenticationManager,
//            UserDetailServiceImpl userDetailsService,
//            JwtTokenUtil jwtTokenUtil,
//            UserRepository userRepository) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userRepository = userRepository;
//    }

    @Override
    public String register(User userToAdd) throws Exception {
        final String username = userToAdd.getUsername();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userToAdd.setRoles(Collections.singletonList("ROLE_USER"));
        userToAdd.setId(UUID.randomUUID().toString());
        Map<String, Object> stringObjectMap = objectToMap(userToAdd);
        redisUtils.hashPutAll(userToAdd.getUsername(),stringObjectMap);
//        RedisUtils.hashPut(userToAdd.getUsername(),"password",userToAdd.getPassword());
//        RedisUtils.hashPut(userToAdd.getUsername(),"LastPasswordResetDate",userToAdd.getLastPasswordResetDate());
//        RedisUtils.hashPut(userToAdd.getUsername(),"Roles",userToAdd.getRoles());
//        RedisUtils.hashPut(userToAdd.getUsername(),"id",userToAdd.getId());
//        RedisUtils.hashPut(userToAdd.getUsername(),"username",userToAdd.getUsername());
        return "register successful";
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }


    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}

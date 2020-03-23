//package cn.kilog.cap.security.config;
//
//import cn.kilog.cap.security.service.impl.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//import javax.sql.DataSource;
//
///**
// * 认证服务器配置
// */
//@Configuration
//@EnableAuthorizationServer
//public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDetailServiceImpl userDetailService;
//
//    @Autowired
//    private TokenStore redisTokenStore;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        /**
//         * redis token 方式
//         */
//        endpoints.authenticationManager(authenticationManager)
//                .userDetailsService(userDetailService)
//                .tokenStore(redisTokenStore);
//
//    }
//    /**
//      * 使用内存或者JDBC来实现客户端详情服务
//      */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 使用JdbcClientDetailsService客户端详情服务
//        // clients.withClientDetails(new JdbcClientDetailsService(dataSource));
////     * authorizedGrantTypes: 授权类型:
////     * authorization_code：授权码类型,在常用，最安全。
////     * implicit：隐式授权类型。
////     * password：资源所有者（即用户）密码类型。
////     * client_credentials：客户端凭据（客户端ID以及Key）类型。
////     * refresh_token：通过以上授权获得的刷新令牌来获取新的令牌v
////        clients.inMemory()
////                .withClient("admin")//配置client_id
////                .secret(passwordEncoder.encode("admin123456"))//配置client_secret
////                .accessTokenValiditySeconds(3600)//配置访问token的有效期
////                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
////                .redirectUris("http://www.baidu.com")//配置redirect_uri，用于授权成功后跳转
////                .scopes("all")//配置申请的权限范围
////                .authorizedGrantTypes("authorization_code","password");//配置grant_type，表示授权类型
////    }
//        clients.inMemory()
//                .withClient("order-client")
//                .secret(passwordEncoder.encode("order-secret-8888"))
//                .authorizedGrantTypes("refresh_token", "authorization_code", "password")
//                .accessTokenValiditySeconds(3600)
//                .scopes("all")
//                .and()
//                .withClient("user-client")
//                .secret(passwordEncoder.encode("user-secret-8888"))
//                .authorizedGrantTypes("refresh_token", "authorization_code", "password")
//                .accessTokenValiditySeconds(3600)
//                .scopes("all");
//    }
//
//    /**
//     * AuthorizationServerEndpointsConfigurer用来配置令牌端点（Token Endpoint）的安全约束
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.allowFormAuthenticationForClients();
//        security.checkTokenAccess("isAuthenticated()");
//        security.tokenKeyAccess("isAuthenticated()");
//    }
//
//
//
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("code-secret-8888"));
//
//    }
//}
//

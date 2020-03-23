package cn.kilog.cap.securityOAuth2.config;


import cn.kilog.cap.securityOAuth2.service.impl.UsernameUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security配置文件
 * 主要继承 WebSecurityConfigurerAdapter 实现访问资源之前的拦截配置。
 * 该拦截器的顺序在资源服务器拦截器之前。
 */
@Configuration
//@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 自动注入UserDetailsService
    @Autowired
    private UsernameUserDetailService usernameUserDetailService;

//    @Autowired
//    private PhoneUserDetailService phoneUserDetailService;
//
//    @Autowired
//    private QrUserDetailService qrUserDetailService;



    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .addFilterAt(getMyLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(getPhoneLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(getQrLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                // 配置登陆页/login并允许访问
//                .formLogin().loginPage("/login").permitAll()
                .formLogin().permitAll()
                // 登出页
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/backReferer")
                // 其余所有请求全部需要鉴权认证
                .and().authorizeRequests()
                .antMatchers("/auth/**","/client","/oauth/**").permitAll()
//                .antMatchers("/auth/**","/client").permitAll()
                .anyRequest().authenticated()
                // 由于使用的是JWT，我们这里不需要csrf
                .and().csrf().disable();
    }

    /**
     * 用户验证
     * @param auth
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(phoneAuthenticationProvider());
        auth.authenticationProvider(daoAuthenticationProvider());
//        auth.authenticationProvider(qrAuthenticationProvider());
    }

/*    @Bean
    public BCryptPasswordEncoder myEncoder(){
        return new BCryptPasswordEncoder(6);
    }*/

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider1 = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider1.setUserDetailsService(usernameUserDetailService);
        // 禁止隐藏用户未找到异常
        provider1.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
        provider1.setPasswordEncoder(passwordEncoder());
        return provider1;
    }


//    @Bean
//    public PhoneAuthenticationProvider phoneAuthenticationProvider(){
//        PhoneAuthenticationProvider provider = new PhoneAuthenticationProvider();
//        // 设置userDetailsService
//        provider.setUserDetailsService(phoneUserDetailService);
//        // 禁止隐藏用户未找到异常
//        provider.setHideUserNotFoundExceptions(false);
//        return provider;
//    }
//
//    @Bean
//    public QrAuthenticationProvider qrAuthenticationProvider(){
//        QrAuthenticationProvider provider = new QrAuthenticationProvider();
//        // 设置userDetailsService
//        provider.setUserDetailsService(qrUserDetailService);
//        // 禁止隐藏用户未找到异常
//        provider.setHideUserNotFoundExceptions(false);
//        return provider;
//    }
//
//
//    /**
//     * 手机验证码登陆过滤器
//     * @return
//     */
//    @Bean
//    public PhoneLoginAuthenticationFilter getPhoneLoginAuthenticationFilter() {
//        PhoneLoginAuthenticationFilter filter = new PhoneLoginAuthenticationFilter();
//        try {
//            filter.setAuthenticationManager(this.authenticationManagerBean());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        filter.setAuthenticationSuccessHandler(new MyLoginAuthSuccessHandler());
//        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
//        return filter;
//    }
//
//    @Bean
//    public QrLoginAuthenticationFilter getQrLoginAuthenticationFilter() {
//        QrLoginAuthenticationFilter filter = new QrLoginAuthenticationFilter();
//        try {
//            filter.setAuthenticationManager(this.authenticationManagerBean());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        filter.setAuthenticationSuccessHandler(new MyLoginAuthSuccessHandler());
//        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"));
//        return filter;
//    }

}
package com.business.auth.config;

import com.business.auth.handler.AuthenticationEntryPointImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;


/**
 * Spring Security 自动配置类，主要用于相关组件的配置
 *
 * 注意，不能和 {@link WebSecurityConfigurer} 用一个，原因是会导致初始化报错。
 * @author yxf
 */
@AutoConfiguration
public class SecurityAutoConfiguration {

    /**
     * 白名单
     */
    private final String[] ignoreUrlsConfig = new String[]{
            "/api-docs/**", //过滤文档访问
            "/swagger-ui/**", //过滤文档访问
            "/pc/user/userLogin", //过滤登录请求
            "/mobile/consumer/sendRegisterOrLoginSms", //过滤发送注册或登录验证码到用户手机请求
            "/mobile/consumer/consumerLogin", //过滤登录请求
            "/mobile/consumer/consumerLoginByPassword", //过滤登录请求

            //过滤部分APP端壁纸信息请求
            "/mobile/wallpaper/getHomeData",
            "/mobile/wallpaper/pageList",

            //过滤根据壁纸文件目录批量新增壁纸信息请求
            "/pc/wallpaper/batchAddWallpaperToDatabase",

            //过滤热搜关键词请求
            "/mobile/hotSearch/**",

            "/mobile/category/**", //过滤用户端 - 壁纸分类请求
            "/comm/**" //过滤公共请求
    };

    /**
     * 配置白名单不走Filter过滤器
     */
    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {
        return (web) -> web.ignoring().requestMatchers(ignoreUrlsConfig);
    }

    /**
     * 认证失败处理类 Bean
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointImpl();
    }


    /**
     * Spring Security 加密器
     * 考虑到安全性，这里采用 BCryptPasswordEncoder 加密器
     *
     * @see <a href="http://stackabuse.com/password-encoding-with-spring-security/">Password Encoding with Spring Security</a>
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

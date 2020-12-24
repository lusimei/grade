package com.school.grade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/unauth.html");//拒绝访问页面

        http.formLogin() //自定义自己编写的登录页面
            .loginPage("/login.html") //登录页面设置
            .loginProcessingUrl("/user/login") //登录访问路径 可以随便写 接口逻辑由security内部处理
            .defaultSuccessUrl("/index").permitAll()//登录成功后跳转的路径
            .and().authorizeRequests()//表示可以定义哪些方法可以被保护，哪些不被保护
            .antMatchers("/","/hello","/user/login","/login.html","/login").permitAll()//直接访问不用登录验证
//            .antMatchers("/index").hasAuthority("admin")//如果当前的主体具有指定的权限
//            .antMatchers("/index").hasAnyAuthority("admin,manager")//如果当前的主体有任何提供的角色
//            .antMatchers("/index").hasRole("sale")
                .antMatchers("").hasAnyRole("sale,look")
            .anyRequest().authenticated()//所有请求都可以访问
            .and().csrf().disable();//关闭csrf防护
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
//        auth.inMemoryAuthentication().withUser("chad").password(bcry.encode("123")).roles("admin");
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

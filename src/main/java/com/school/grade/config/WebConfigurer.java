package com.school.grade.config;
import com.school.grade.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        loginRegistry.addPathPatterns("/web/**");
        loginRegistry.excludePathPatterns("/**/login");
//        loginRegistry.excludePathPatterns("/**/*.css");
//        loginRegistry.excludePathPatterns("/**/*.js");
//        loginRegistry.excludePathPatterns("/**/*.png");
//        loginRegistry.excludePathPatterns("/**/*.gif");
//        loginRegistry.excludePathPatterns("/**/*.jpg");
//        loginRegistry.excludePathPatterns("/**/*.font");
//        loginRegistry.excludePathPatterns("/**/*.icon");
    }

    //springboot解决The valid characters are defined in RFC 7230 and RFC 3986
    /*
     * 在本机使用Postman测试接口时将下面注释去除，不然如果参数有list集合会报上面一行的错，上传tomcat测试网
     * 或者正式公网时需注释，因为tomcat测试网或公网上的tomcat版本是7的版本，所以无需添加以下代码（2019-11-26）
     */
//    @Bean
//    public ConfigurableServletWebServerFactory webServerFactory() {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//            @Override
//            public void customize(Connector connector) {
//                connector.setProperty("relaxedQueryChars", "|{}[]");//允许的特殊字符
//            }
//        });
//        return factory;
//    }

}

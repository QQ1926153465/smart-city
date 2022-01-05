package com.briup.smartcity.config;

import com.briup.smartcity.web.interceptor.JwtInterceptor;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JwtInterceptor jwtInterceptor;
    //拦截器


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("添加拦截器");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/auth/**");

    }

    ///跨域请求的问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  //所有url
                .allowedMethods("POST","GET","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")//任意头信息
                .allowedOrigins("*") //任意客户端
                .maxAge(3600);// 向浏览器返回跨域信息，能够在浏览器中保存时间 单位s
    }

}

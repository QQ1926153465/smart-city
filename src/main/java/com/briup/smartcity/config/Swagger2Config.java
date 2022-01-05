package com.briup.smartcity.config;


import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 工具类 ，只要使用配置即可
 * 1.指定swagger生成文档对应的接口信息：
 * RequestHandlerSelectors.basePackage();
 * 2.指定swagger首页的系统基本信息
 *  修改 apiInfo()
 * 3.JWT 验证 指定 请求头中传递的参数名称
 *  修改 new ApiKey
 * 4.JWT验证在哪些接口中自动添加请求头
 *   修改antPaths //ant风格   /a/b/c  /c   /a/** /a/* /a/?
 */
@EnableSwagger2 // 支持使用swagger2
@Configuration  //配置类 ：
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.briup.smartcity.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security())
                .securityContexts(securityContexts());
    }
    //swagger界面中显示的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("智慧城市资讯云平台")
                .description("欢迎访问briup官网，http://www.briup.com")
                .termsOfServiceUrl("http://www.briup.com")
                .version("1.0")
                .build();
    }

    private List<ApiKey> security() {
        return Collections.singletonList(
                // 测试 token=XXX.xxx.xxx
                //将一个Authorization的key=value 添加请求头信息中
                new ApiKey("Authorization", "Authorization", "header")
        );
    }
    /**
     * 设置认证规则
     */
    private List<SecurityContext> securityContexts() {
        //操作页面，自有在/auth/** 下添加token字符串
        List<String> antPaths = new ArrayList<>(Arrays.asList("/auth/**"));
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(antPathsCondition(antPaths))
                        .build()
        );
    }

    /**
     * 返回认证路径的条件
     */
    private Predicate<String> antPathsCondition(List<String> antPaths){
        List<Predicate<String>> list = new ArrayList<>();
        antPaths.forEach(path->list.add(PathSelectors.ant(path)));
        return Predicates.or(list);
    }

    /**
     * 设置认证的范围，以及认证的字段名称
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
                new SecurityReference("Authorization", authorizationScopes));
    }
}
package com.example.demotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.channels.Pipe;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {


        return new Docket(DocumentationType.SWAGGER_2)
                //用于分组功能，也可以不配置
                .groupName("Dev")
                .select()
//               扫描指定包： controller的包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demotest.controller"))
//                设置此组只匹配
                .paths(PathSelectors.any())
                //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
                .build().apiInfo(new ApiInfoBuilder()
//                        页面标题
                        .title("SpringBoot整合Swagger")
//                        描述
                        .description("SpringBoot整合Swagger，详细信息......")
//                        版本号
                        .version("9.0")
                        .termsOfServiceUrl("http://localhost:8080/api")
                        .contact(new Contact("啊啊啊啊", "blog.csdn.net", "aaa@gmail.com"))
//                        需要跳转的路劲，及命名
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build());


    }


}

package com.ncs.recruit.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerDocsConfiguration {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    /**
     * name:开发者姓名
     * url:开发者网址
     * email:开发者邮箱
     *
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("南峰", "http://www.xiaomin2019.xyz", "xueyj163@163.com");
        return new ApiInfoBuilder()
            .title("NCS 社会人才招聘系统API接口文档")//标题
            .description("NCS 社会人才招聘系统API接口文档说明")//文档接口的描述
            .contact(contact)
            .version("1.1.0")//版本号
            .build();
    }
}
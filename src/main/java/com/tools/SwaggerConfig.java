package com.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 20:33
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.controller")) // 用于指定扫描哪个包下的接口
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring-boot测试项目API") //主标题
                .description("spring-boot测试项目SwaggerAPI管理") //描述整体的API
                .termsOfServiceUrl("") //定义服务的域名
                .version("1.0") //定义版本。
                .build(); //
    }
}

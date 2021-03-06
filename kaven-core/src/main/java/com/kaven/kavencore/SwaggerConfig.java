package com.kaven.kavencore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@SuppressWarnings("unchecked")
	@Bean
    public Docket createRestApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
		         .groupName("MSKaven")
		         .genericModelSubstitutes(DeferredResult.class)
		         .genericModelSubstitutes(ResponseEntity.class)
		         .useDefaultResponseMessages(false)
		         .forCodeGeneration(false)
		         .pathMapping("/")
		         .select()
		         .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
		         .build()
		         .apiInfo(apiInfo());
    }
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                //.description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                //.termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("wangwei", "www", "ww"))
                .version("1.0")
                .build();
    }

}

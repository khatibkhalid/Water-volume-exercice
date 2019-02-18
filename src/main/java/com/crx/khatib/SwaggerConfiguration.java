package com.crx.khatib;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {
	
	@Value("${project.version}")
	private String projectVersion;
	
	
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 .apis(RequestHandlerSelectors.basePackage("com.crx.khatib.controller"))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build().apiInfo(apiInfo());
             
    }
  @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
 
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
  
  @Bean
  public ApiInfo apiInfo() {
    return new ApiInfo("Water volume calculator",
        "A Rest API which calculates the volume of water filled in between bars after a heavy rain",
        "version " + projectVersion, "TODO Terms of service", new Contact("Khalid Khatib", "", "khalid.khatib.inf@gmail.com"),
        "License of API", "API license URL", new ArrayList<VendorExtension>());
  }
}
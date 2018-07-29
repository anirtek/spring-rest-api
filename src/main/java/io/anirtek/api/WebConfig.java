package io.anirtek.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
//	@Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        registry.addMapping("/api/**")
//            .allowedOrigins("http://mocket.egen.io")
//            .allowedMethods("PUT", "DELETE", "GET", "POST", "UPDATE", "PATCH", "OPTIONS")
//            .allowedHeaders("header1", "header2", "header3")
//            .exposedHeaders("header1", "header2")
//            .allowCredentials(true).maxAge(3600);
//
//        // Add more mappings...
//    }
}
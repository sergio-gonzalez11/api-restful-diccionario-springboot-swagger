package api.rest.diccionario.conf;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.rest.diccionario.handler.ResponseExceptionHandler;

@Configuration
public class WebConfig {
	
	@Bean 
	public ObjectMapper objectMapper() {        
		return new ObjectMapper();
	}

	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {  
		return restTemplateBuilder.errorHandler(new ResponseExceptionHandler()).build();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*");
			}
			
		};
	}

}

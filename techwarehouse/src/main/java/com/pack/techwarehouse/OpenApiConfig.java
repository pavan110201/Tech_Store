package com.pack.techwarehouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig 
{
	@Bean
	public OpenAPI carDatabaseOpenAPI() 
	{
		return new OpenAPI().info(new Info().title("Laptop REST API").description("My Tech Base").version("1.0"));
	}
}
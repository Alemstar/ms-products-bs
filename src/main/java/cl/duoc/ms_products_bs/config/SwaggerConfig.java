package cl.duoc.ms_products_bs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI() 
                   .info(new Info().title("Products microservice - Business Logic (BS) Documentation.")
                                    .description("This microservice allows us to implement business rules and define how the received data will be processed.")
                                    .version("1.0"));
    }

}

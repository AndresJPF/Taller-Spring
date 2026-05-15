package taller.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration indica que esta clase tiene configuraciones para Spring
@Configuration
public class SwaggerConfig {

    // Este metodo configura la informacion que aparece en Swagger
    @Bean
    public OpenAPI configurarSwagger() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Productos")
                .description("API RESTful para gestionar el catalogo de productos")
                .version("1.0")
            );
    }
}

package financial.dev.financial_api_challenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Desafio Itáu - Todesco")
                                .description("Api do desafio tecnico do banco Itáu")
                                .version("1.0.0")
                );
    }
}

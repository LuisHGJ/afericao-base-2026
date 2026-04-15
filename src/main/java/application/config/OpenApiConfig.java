package application.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    servers = {
        @Server(url="/", description="Servidor Atual"),
        @Server(url="https://api-teste.com", description="Servidor de Teste")
    }
)

public class OpenApiConfig {
    
}

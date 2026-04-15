package application.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.security.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequiriment;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API sensores",
        version = "v1",
        description = "API para gerenciamento de dados recebidos de sensores",
        contact = @Contact(
            name = "Luis",
            email = "luis@gmail.com"
        )
    ),
    servers = {
        @Server(url="/", description="Servidor Atual"),
        @Server(url="https://api-teste.com", description="Servidor de Teste")
    },
    security = @SecurityRequirement(name = "bearerAuth")
)

@SecurityScheme(
    name ="bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat "JWT"
)

public class OpenApiConfig {
    
}

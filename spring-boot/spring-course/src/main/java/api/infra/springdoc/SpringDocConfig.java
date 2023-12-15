package api.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfig {

	// método que informa ao SpringDoc para utilizar token de autenticação; utilizado em conjunto com a anotação
	// @SecurityRequirement(name = "bearer-key") nos métodos ou controllers
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearer-key",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
				.info(new Info().title("Spring Course API")
						.description(
								"API Rest utilizada no curso de Spring Boot 3. Possui as funcionalidades de CRUD de médicos e pacientes, além do agendamento de consultas.")
						.contact(new Contact().name("Time Backend").email("time@backend.com")));
	}
}

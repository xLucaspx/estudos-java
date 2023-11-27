package api.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // anotação para o Spring carregar esta classe como uma classe de configurações
@EnableWebSecurity // anotação para informar ao Spring que vamos personalizar as configurações de segurança
public class SecurityConfig {

	@Bean // anotação para expor o retorno do método para o Spring
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// desabilitando a proteção padrão contra ataques csrf (o token que vamos implementar já será uma proteção)
		// e configurando a autenticação para ser stateless; isso praticamente desabilita o padrão do Spring Security
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
}

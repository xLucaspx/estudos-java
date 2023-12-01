package api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // anotação para o Spring carregar esta classe como uma classe de configurações
@EnableWebSecurity // anotação para informar ao Spring que vamos personalizar as configurações de segurança
public class SecurityConfig {

	@Autowired
	private SecurityFilter securityFilter;

	@Bean // anotação para expor o retorno do método para o Spring
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// desabilitando a proteção padrão contra ataques csrf (o token que vamos implementar já será uma proteção)
		// e configurando a autenticação para ser stateless; isso praticamente desabilita o padrão do Spring Security
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(req -> {
					// declarando a rota de login como pública:
					req.requestMatchers(HttpMethod.POST, "/login").permitAll();
					// exigindo autenticação para as outras rotas:
					req.anyRequest().authenticated();
				}) // declarando que o securityFilter deve ser executado antes do filtro do Spring
						// (UsernamePasswordAuthenticationFilter)
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	// Para utilizar a autenticação com o Spring Security, é necessário um objeto do tipo AuthenticationManager; para que
	// o Spring consiga injetar este objeto na controller precisamos ensiná-lo, ou seja, criar um método com a anotação
	// @Bean que retorna este objeto:
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

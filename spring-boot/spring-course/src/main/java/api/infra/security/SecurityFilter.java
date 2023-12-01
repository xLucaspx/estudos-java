package api.infra.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // anotação utilizada para que o Spring carregue uma classe/componente genérico
// herdamos a classe OncePerRequestFilter do Spring para criar um filtro integrado ao Spring
// e que é garantido que será chamado uma vez por requisição
public class SecurityFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var tokenJwt = recuperaToken(request);
		System.out.println(
				"Requisição executada em " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()) + "\n" + tokenJwt);

		filterChain.doFilter(request, response); // utilizamos o filterChain para seguir o fluxo dos filtros
	}

	private String recuperaToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");
		
		if (authorizationHeader == null) throw new RuntimeException("Token de autorização não enviado no cabeçalho Authorization");
		
		return authorizationHeader.replace("Bearer ", "");
	}
}

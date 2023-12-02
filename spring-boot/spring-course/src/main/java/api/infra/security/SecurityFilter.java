package api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import api.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // anotação utilizada para que o Spring carregue uma classe/componente genérico
// herdamos a classe OncePerRequestFilter do Spring para criar um filtro integrado ao Spring
// e que é garantido que será chamado uma vez por requisição
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var tokenJwt = recuperaToken(request);

		if (tokenJwt != null) {
			// nosso método getSubject já valida o token
			var subject = tokenService.getSubject(tokenJwt);
			// buscando o usuário no banco
			var usuario = usuarioRepository.findByUsername(subject);
			// criando um objeto authentication: basicamente um FTO do spring que representa o usuário autenticado;
			// recebe o próprio usuário, uma lista de credenciais (no caso null) e a lista de roles (metodo getAuthorities())
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			// Força a autenticação pelo Spring; a partir de agora o Spring considera este usuário autenticado
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response); // utilizamos o filterChain para seguir o fluxo dos filtros
	}

	private String recuperaToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");

		return authorizationHeader != null ? authorizationHeader.replace("Bearer ", "") : null;
	}
}

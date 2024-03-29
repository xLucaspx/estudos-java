package api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import api.domain.usuario.Usuario;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;
	@Value("${api.security.token.issuer}")
	private String issuer;

	public String geraToken(Usuario user) {
		System.out.println(issuer);
		try {
			var algorithm = Algorithm.HMAC256(secret);
			// issuer = quem foi responsável pela geração do token (neste caso a API)
			// subject = quem é a pessoa relacionada com o token (o usuário)
			// withClaim() = metodo para adicionar informações ao token (chave, valor)
			// withExpitesAt() = define a data de expiração do Token
			var token = JWT.create()
					.withIssuer(issuer)
					.withSubject(user.getUsername())
					.withClaim("id", user.getId())
					.withExpiresAt(getDataExpiracao())
					.sign(algorithm);
			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao gerar token JWT", e);
		}
	}

	public String getSubject(String tokenJwt) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer(issuer).build().verify(tokenJwt).getSubject();
		} catch (JWTVerificationException e) {
			throw new RuntimeException("Token de autorização inválido ou expirado!");
		}
	}

	private Instant getDataExpiracao() {
		// definindo que o token é válido por duas horas:
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}

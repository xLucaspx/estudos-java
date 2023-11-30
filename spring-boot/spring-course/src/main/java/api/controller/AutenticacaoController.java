package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.domain.usuario.DadosAutenticacao;
import api.domain.usuario.Usuario;
import api.infra.security.DadosTokenJwt;
import api.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	// é necessário utilizar a interface AuthenticationManager do Spring Security para chamar o serviço de autenticação;
	// não devemos chamar a service diretamente.
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> efetuaLogin(@RequestBody @Valid DadosAutenticacao dados) {
		// o Spring tem um DTO próprio para representar o usuário e a senha: UsernamePasswordAuthenticationToken;
		// o método authenticate() do AuthenticationManager recebe este DTO como parâmetro.
		var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		// devolve um objeto que representa o usuário autenticado no sistema
		var authentication = manager.authenticate(authToken);
		var tokenJwt = tokenService.geraToken((Usuario) authentication.getPrincipal());

		return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
	}
}

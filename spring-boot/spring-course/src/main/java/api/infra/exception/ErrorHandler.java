package api.infra.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import api.domain.exceptions.ValidationException;
import jakarta.persistence.EntityNotFoundException;

// A anotação @RestControllerAdvice serve para que o Spring carregue esta classe quando rodarmos o projeto;
// no caso, esta anotação é específica para a classe que vai tartar os erros da API
@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> handleBadRequest400(ValidationException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	// MethodArgumentNotValidException é jogada quando falham as validações Bean Validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	// Para receber a exception como parâmetro do método, basta declarar a mesma da anotação @ExceptionHandler
	public ResponseEntity<List<DadosErroValidacao>> handleBadRequest400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors().stream().map(DadosErroValidacao::new).toList();

		return ResponseEntity.badRequest().body(erros);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleBadRequest400(HttpMessageNotReadableException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> handleBadCredentials401() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais de acesso inválidas!");
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationException401() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação!");
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> handleForbidden403() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado!");
	}

	// para a anotação @ExceptionHandler passamos a classe da Exception que queremos tratar;
	// dessa forma, sempre que tal exception for lançada, este método será chamado
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleNotFound404() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAny500(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
	}

	private record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}

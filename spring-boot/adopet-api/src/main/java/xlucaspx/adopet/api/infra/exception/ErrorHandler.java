package xlucaspx.adopet.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xlucaspx.adopet.api.exception.NaoEncontradoException;
import xlucaspx.adopet.api.exception.ValidacaoException;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<String> handleBadRequest400(ValidacaoException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleBadRequest400(HttpMessageNotReadableException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	// MethodArgumentNotValidException é jogada quando falham as validações Bean Validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErroValidacao>> handleBadRequest400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors().stream().map(DadosErroValidacao::new).toList();

		return ResponseEntity.badRequest().body(erros);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFound404() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<String> handleNaoEncontrado404(NaoEncontradoException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAny500(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + ex.getLocalizedMessage());
	}

	record DadosErroValidacao(String campo, String mensagem) {
		public DadosErroValidacao(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}

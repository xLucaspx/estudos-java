package api.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

// A anotação @RestControllerAdvice serve para que o Spring carregue esta classe quando rodarmos o projeto;
// no caso, esta anotação é específica para a classe que vai tartar os erros da API
@RestControllerAdvice
public class ErrorHandler {

	// para a anotação @ExceptionHandler passamos a classe da Exception que queremos tratar;
	// dessa forma, sempre que tal exception for lançada, este método será chamado
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handle404() {
		return ResponseEntity.notFound().build();
	}

	// MethodArgumentNotValidException é jogada quando falham as validações Bean Validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	// Para receber a exception como parâmetro do método, basta declarar a mesma da anotação @ExceptionHandler
	public ResponseEntity<List<DadosErroValidacao>> handle400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors().stream().map(DadosErroValidacao::new).toList();

		return ResponseEntity.badRequest().body(erros);
	}

	private record DadosErroValidacao(String campo, String mensagem) {

		public DadosErroValidacao(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}

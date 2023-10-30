package api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping // se chegar uma requisição GET para /hello será chamado este método
	public String helloWorld() {
		return "<h1>Hello, world from Spring Boot!</h1>";
	}
}

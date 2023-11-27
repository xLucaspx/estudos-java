package api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // anotação para o spring carregar a classe como um componente de serviço
// a interface UserDetailsService deve ser implementada na classe que fará o serviço de autenticação;
// dessa forma, e com a anotação @Service, o Spring irá se encarregar de chamá-la quando necessário
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByUsername(username);
	}
}

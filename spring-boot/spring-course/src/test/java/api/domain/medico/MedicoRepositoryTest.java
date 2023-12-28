package api.domain.medico;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

// @DataJpaTest é usada quando queremos realizar testes na camada de persistência (geralmente interfaces Repository)
@DataJpaTest
// anotação para configurar o banco de dados de teste; ao passar Replace.NONE, dizemos que não queremos que o
// Spring substitua o banco de dados (Senão o Spring tenta usar um banco em memória como configuração padrão)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") // dizendo que queremos carregar as propriedades do arquivo application-test.properties
class MedicoRepositoryTest {

	@Test
	void testEscolheMedicoLivreNaDataPorEspecialidade() {

	}
}

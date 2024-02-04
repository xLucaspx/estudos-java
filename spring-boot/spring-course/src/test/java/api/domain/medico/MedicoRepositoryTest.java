package api.domain.medico;

import api.domain.consulta.Consulta;
import api.domain.endereco.EnderecoDto;
import api.domain.paciente.CadastroPacienteDto;
import api.domain.paciente.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

// @DataJpaTest é usada quando queremos realizar testes na camada de persistência (geralmente interfaces Repository)
@DataJpaTest
// anotação para configurar o banco de dados de teste; ao passar Replace.NONE, dizemos que não queremos que o
// Spring substitua o banco de dados (Senão o Spring tenta usar um banco em memória como configuração padrão)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") // dizendo que queremos carregar as propriedades do arquivo application-test.properties
class MedicoRepositoryTest {

	// podemos fazer injeção de dependências nas classes de teste utilizando o JUnit e as anotações do Spring Boot
	@Autowired
	private MedicoRepository medicoRepository;
	// para preencher o banco de dados vamos utilizar um EntityManager próprio para testes automatizados
	// desta forma, ao final de cada método o Spring faz o rollback e cada método de teste não interfere nos outros
	@Autowired
	private TestEntityManager em;

	@Test
	@DisplayName("Deve devolver null quando o único médico cadastrado não está disponível na data")
	void escolheMedicoLivreNaDataPorEspecialidadeCenario1() {
		// os métodos de teste podem ser divididos em 3 partes (conceito): given/arrange, when/act, then/assert
		// given ou arrange
		var proximaSegundaAs10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

		var medico = cadastraMedico("Fulano", "dr-fulano@med.com.br", "234097", Especialidade.CARDIOLOGIA);
		var paciente = cadastraPaciente("Pafúncio", "pafuncio@email.com", "12345678909");

		cadastraConsulta(medico, paciente, proximaSegundaAs10);

		// when ou act
		var medicoLivre = medicoRepository.escolheMedicoLivreNaDataPorEspecialidade(proximaSegundaAs10,
			Especialidade.CARDIOLOGIA
		);

		// then ou assert
		assertThat(medicoLivre).isNull();
	}

	@Test
	@DisplayName("Deve devolver o único médico cadastrado quando ele estiver disponível na data")
	void escolheMedicoLivreNaDataPorEspecialidadeCenario2() {
		var proximaSegundaAs10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

		var medico = cadastraMedico("Fulano", "dr-fulano@med.com.br", "234097", Especialidade.CARDIOLOGIA);

		var medicoLivre = medicoRepository.escolheMedicoLivreNaDataPorEspecialidade(proximaSegundaAs10,
			Especialidade.CARDIOLOGIA
		);

		assertThat(medicoLivre).isEqualTo(medico);
	}

	private void cadastraConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
		em.persist(new Consulta(paciente, medico, data));
	}

	private Medico cadastraMedico(String nome, String email, String crm, Especialidade especialidade) {
		var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
		em.persist(medico);
		return medico;
	}

	private Paciente cadastraPaciente(String nome, String email, String cpf) {
		var paciente = new Paciente(dadosPaciente(nome, email, cpf));
		em.persist(paciente);
		return paciente;
	}

	private CadastroMedicoDto dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
		return new CadastroMedicoDto(nome, email, crm, "51 3234-5678", especialidade, dadosEndereco());
	}

	private CadastroPacienteDto dadosPaciente(String nome, String email, String cpf) {
		return new CadastroPacienteDto(nome, email, "51 3344-5678", cpf, dadosEndereco());
	}

	private EnderecoDto dadosEndereco() {
		return new EnderecoDto("90619-900", "Avenida Ipiranga", "Partenon", "Porto Alegre", "RS", "6681", null);
	}
}

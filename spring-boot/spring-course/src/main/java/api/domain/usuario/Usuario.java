package api.domain.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	@Column(name = "hash_senha")
	private String hashSenha;

	public Usuario() {}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getHashSenha() {
		return hashSenha;
	}

	@Override
	public int hashCode() {
		return id * username.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Usuario usuario = (Usuario) o;
		return id == usuario.getId() && username.equals(usuario.getUsername());
	}
}

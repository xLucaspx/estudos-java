package models;

import java.util.ArrayList;

public class Usuario {
  private String nome;
  private String cidadeUf;
  private String email;
  private String senha;
  private ArrayList<String> skills;
  private String idiomaPrincipal;
  private String idiomaSecundario;

  public Usuario(String nome, String cidadeUf, String email, String senha, String idiomaPrincipal) {
    setNome(nome);
    setCidadeUF(cidadeUf);
    setEmail(email);
    setSenha(senha);
    setIdiomaPrincipal(idiomaPrincipal);
    skills = new ArrayList<>();
  }

  private void setNome(String nome) {
    if (nome == null || nome.trim().isEmpty())
      throw new IllegalArgumentException("O nome não pode ser nulo ou vazio. Valor inserido: " + nome);

    this.nome = nome;
  }

  private void setCidadeUF(String cidadeUf) {
    if (cidadeUf == null || cidadeUf.trim().isEmpty())
      throw new IllegalArgumentException("A cidade não pode ser nula ou vazia. Valor inserido: " + cidadeUf);

    this.cidadeUf = cidadeUf;
  }

  private void setEmail(String email) {
    if (email == null || !email.matches(
        "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"))
      throw new IllegalArgumentException("O e-mail inserido não é válido. E-mail inserido: " + email);

    this.email = email;
  }

  private void setSenha(String senha) {
    if (senha == null || !senha.matches(
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*\\(\\)_+\\-=\\{\\[\\}\\]:;>.<,?/\\|\\\\])[A-Za-z\\d!@#$%&*\\(\\)_+\\-=\\{\\[\\}\\]:;>.<,?/\\|\\\\]{8,}$"))
      throw new IllegalArgumentException(
          "A senha deve ter no mínimo 8 caracteres, uma letra maiúscula, uma minúscula, um número e um caractere especial!");

    this.senha = senha;
  }

  private void setIdiomaPrincipal(String idiomaPrincipal) {
    if (idiomaPrincipal == null || idiomaPrincipal.trim().isEmpty())
      throw new IllegalArgumentException(
          "O idioma principal não pode ser nulo ou vazio. Valor inserido: " + idiomaPrincipal);

    this.idiomaPrincipal = idiomaPrincipal;
  }

  public void setIdiomaSecundario(String idiomaSecundario) {
    if (idiomaSecundario == idiomaPrincipal || idiomaSecundario == null || idiomaSecundario.trim().isEmpty())
      return;

    this.idiomaSecundario = idiomaSecundario;
  }

  public void addSkill(String skill) {
    skills.add(skill);
  }

  public String getSenha() {
    return senha;
  }

  @Override
  public String toString() {
    return String.format(
        "Nome: %s\nE-mail: %s\nCidade - UF: %s\nIdioma primário: %s\nIdioma secundário: %s\nSkills: %s", nome, email,
        cidadeUf, idiomaPrincipal, idiomaSecundario != null ? idiomaSecundario : "Não possui",
        skills.size() > 0 ? skills : "Não possui");
  }
}

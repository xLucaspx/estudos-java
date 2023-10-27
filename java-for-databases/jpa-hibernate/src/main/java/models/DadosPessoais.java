package models;

import jakarta.persistence.Embeddable;

@Embeddable
public record DadosPessoais(String nome, String cpf) {}

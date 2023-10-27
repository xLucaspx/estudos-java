package models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public record CategoriaId(String nome, String tipo) implements Serializable {}

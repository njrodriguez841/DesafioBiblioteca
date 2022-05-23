package com.desafiolatam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="libros")


public class Libro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	private String titulo;
	
	@NotNull
	private Integer anio;
	
	@NotNull
	private String autor;
	
	@NotNull
	private String imprenta;
	
	@NotNull
	private Boolean disponible;

	public Libro() {
		super();
	}

	public Libro(Long id, @NotNull String titulo, @NotNull Integer anio, @NotNull String autor, @NotNull String imprenta,
			@NotNull Boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
}

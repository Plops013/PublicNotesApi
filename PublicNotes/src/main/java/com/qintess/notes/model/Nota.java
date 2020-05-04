package com.qintess.notes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Nota {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "titulo é obrigatório")
	private String titulo;
	@Column(columnDefinition = "TEXT")
	@NotEmpty(message = "é obrigatório")
	private String texto;
	@ManyToOne
	private GrupoNotas grupoNotas;
	private boolean publico;
	
	public boolean isPublico() {
		return publico;
	}
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public GrupoNotas getGrupoNotas() {
		return grupoNotas;
	}
	public void setGrupoNotas(GrupoNotas grupoNotas) {
		this.grupoNotas = grupoNotas;
	}
	
}

package com.qintess.notes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("usuario")
public class GrupoNotas {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private boolean publico;
	private boolean protegidoComSenha;
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	@Length(min = 3, max = 6, message = "Escolha uma senha simples, entre 3 e 6 caracteres")
	private String senha;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoNotas", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Nota> notas = new ArrayList<>();
	
	public void addNota(Nota nota) {
		this.notas.add(nota);
	}
	
	public void removeNota(Nota nota) {
		this.notas.remove(nota);
	}
	
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isPublico() {
		return publico;
	}
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	public boolean isProtegidoComSenha() {
		return protegidoComSenha;
	}
	public void setProtegidoComSenha(boolean protegidoComSenha) {
		this.protegidoComSenha = protegidoComSenha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return senha;
	}
	public void setPassword(String password) {
		this.senha = password;
	}
	
	
	
}

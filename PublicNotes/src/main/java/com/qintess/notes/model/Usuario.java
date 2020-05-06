package com.qintess.notes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@Length(min = 5, max = 20, message = "Seu nick deve conter entre 5 e 20 caracteres") 
//	@NotEmpty(message = "Nickname é obrigatório")
	private String nickname;
//	@Length(min = 10, max = 100, message = "seu email deve conter entre 10 e 100 carcteres") @Email  
//	@NotEmpty(message = "Email é obrigatório")
	private String email;
//	@Length(min = 6, message = "Tamanho minimo permitido: 6 caracteres")  
//	@NotEmpty(message = "senha é obrigatório")
	private String senha;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	private List<GrupoNotas> gruposNotas = new ArrayList<GrupoNotas>();
	
	
	
	public Usuario(long id, String nickname, String email, String senha, List<GrupoNotas> gruposNotas) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.email = email;
		this.senha = senha;
		this.gruposNotas = gruposNotas;
	}
	public Usuario() {}

	public void addGrupoNotas(GrupoNotas grupoNotas) {
		grupoNotas.setUsuario(this);
		this.gruposNotas.add(grupoNotas);
	}
	
	public void removeGrupoNotas(GrupoNotas grupoNotas) {
		grupoNotas.setUsuario(null);
		this.gruposNotas.remove(grupoNotas);
	}
	
	public List<GrupoNotas> getGruposNotas() {
		return gruposNotas;
	}
	public void setGruposNotas(List<GrupoNotas> gruposNotas) {
		this.gruposNotas = gruposNotas;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}

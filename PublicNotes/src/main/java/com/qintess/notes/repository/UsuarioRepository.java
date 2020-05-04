package com.qintess.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.notes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
}

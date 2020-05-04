package com.qintess.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.notes.model.GrupoNotas;
import com.qintess.notes.model.Usuario;

public interface GrupoNotasRepository extends JpaRepository<GrupoNotas, Long>{

	public List<GrupoNotas> findByUsuario(Usuario usuario);
	
}

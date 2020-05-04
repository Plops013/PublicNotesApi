package com.qintess.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.notes.model.GrupoNotas;
import com.qintess.notes.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long>{

	public List<Nota> findByGrupoNotas(GrupoNotas grupoNotas);
	
	public List<Nota> findByPublicoTrue();
	
}

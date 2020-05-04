package com.qintess.notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.notes.model.GrupoNotas;
import com.qintess.notes.model.Usuario;
import com.qintess.notes.repository.GrupoNotasRepository;

@Service
public class GrupoNotasService {

	@Autowired
	private GrupoNotasRepository grupoNotasRepository;
	@Autowired
	private UsuarioService usuarioService;
	
	public GrupoNotas saveOrUpdate(GrupoNotas grupoNotas) {
		return this.grupoNotasRepository.save(grupoNotas);
	}
	
	public void delete(GrupoNotas grupoNotas) {
		this.grupoNotasRepository.deleteById(grupoNotas.getId());
	}
	
	public GrupoNotas findById(Long id) {
		return this.grupoNotasRepository.findById(id).get();
	}
	
	public List<GrupoNotas> findAll(){
		return this.grupoNotasRepository.findAll();
	}
	
	public List<GrupoNotas> findByUsuario(Usuario usuario) {
		return this.grupoNotasRepository.findByUsuario(usuario);
	}
	
	public List<GrupoNotas> findByUsuarioId(Long id) {
		Usuario usuario = usuarioService.findById(id);
		return this.grupoNotasRepository.findByUsuario(usuario);
	}
	
}

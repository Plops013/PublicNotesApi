package com.qintess.notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.notes.model.GrupoNotas;
import com.qintess.notes.model.Nota;
import com.qintess.notes.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;
	@Autowired
	GrupoNotasService grupoNotasService;
	@Autowired
	UsuarioService usuarioService;
	
	public Nota saveOrUpdate(Nota nota) {
		return this.notaRepository.save(nota);
	}
	
	public void delete(Nota nota) {
		this.notaRepository.deleteById(nota.getId());
	}
	
	public void deleteById(long id) {
		this.notaRepository.deleteById(id);
	}
	
	public List<Nota> findByGrupoNotas(GrupoNotas grupoNotas){
		return this.notaRepository.findByGrupoNotas(grupoNotas);
	}
	
	public List<Nota> findByGrupoOfUsuario(long idGrupoNotas, long idUsuario){
		GrupoNotas grupoNotas = 
				this.grupoNotasService.findByUsuario(usuarioService.findById(idUsuario))
				.stream()
				.filter(gpNotas -> gpNotas.getId() == idGrupoNotas)
				.findFirst()
				.get();
		return this.notaRepository.findByGrupoNotas(grupoNotas);
	}
	
	public List<Nota> findPublicNotes(){
		return this.notaRepository.findByPublicoTrue();
	}
	
	public Nota findById(long id) {
		return this.notaRepository.findById(id).get();
	}
	
}

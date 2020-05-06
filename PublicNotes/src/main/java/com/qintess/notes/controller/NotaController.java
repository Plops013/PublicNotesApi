package com.qintess.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.notes.model.Nota;
import com.qintess.notes.services.NotaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NotaController {

	@Autowired
	NotaService notaService;
	
	@GetMapping("/usuario/{idUsuario}/grupo/{idGrupo}")
	public List<Nota> notaByGrupoOfUsuario(@PathVariable(value = "idUsuario") long idUsuario,
			@PathVariable(value = "idGrupo") long idGrupoNotas){
		return notaService.findByGrupoOfUsuario(idGrupoNotas, idUsuario);
	}
	
	@GetMapping("/nota/{id}")
	public Nota getNotaById(@PathVariable(value = "id") long id) {
		return this.notaService.findById(id);
	}
	
	@PostMapping("/nota")
	public Nota createNota(Nota nota) {
		return this.notaService.saveOrUpdate(nota);
	}
	
	@DeleteMapping("/nota/{id}")
	public void deleteNota(@PathVariable(value = "id") long id) {
		this.notaService.deleteById(id);
	}
	
	@PutMapping("/nota")
	public Nota updateNota(Nota nota) {
		return this.notaService.saveOrUpdate(nota);
	}
	
	
}

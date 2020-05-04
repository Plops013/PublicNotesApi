package com.qintess.notes.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.notes.model.GrupoNotas;
import com.qintess.notes.services.GrupoNotasService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GrupoNotasController {

	@Autowired
	GrupoNotasService grupoNotasService;
	
	@GetMapping("/usuario/{idUsuario}/grupos")
	public List<GrupoNotas> getGruposByUsuario(@PathParam(value = "idUsuario") long id){
		return this.grupoNotasService.findByUsuarioId(id);
	}
	
	@GetMapping("/grupo")
	public List<GrupoNotas> getAll(){
		return this.grupoNotasService.findAll();
	}
	
	@GetMapping("/grupo/{id}")
	public GrupoNotas getAll(@PathParam(value = "id") long id){
		return this.grupoNotasService.findById(id);
	}
	
	@PostMapping("/grupo")
	public GrupoNotas createGrupoNotas(GrupoNotas grupoNotas) {
		return this.grupoNotasService.saveOrUpdate(grupoNotas);
	}
	
	@PutMapping("/grupo")
	public GrupoNotas updateGrupoNotas(GrupoNotas grupoNotas) {
		return this.grupoNotasService.saveOrUpdate(grupoNotas);
	}
	
	@DeleteMapping("/grupo/{id}")
	public void deleteById(@PathParam(value = "id") long id) {
		this.grupoNotasService.delete(this.grupoNotasService.findById(id));
	}
	
}

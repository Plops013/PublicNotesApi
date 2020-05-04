package com.qintess.notes.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.notes.model.Usuario;
import com.qintess.notes.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public Usuario getUsuario(@PathParam(value = "id") long id) {
		return this.usuarioService.findById(id);
	}
	
	@GetMapping("/")
	public List<Usuario> getAllUsuarios() {
		return this.usuarioService.findAll();
	}
	
	@PostMapping("/")
	public Usuario createUsuario(@Valid Usuario usuario) {
		return this.usuarioService.saveOrUpdate(usuario);
	}
	
	@PutMapping("/")
	public Usuario updateUsuario( Usuario usuario) {
		return this.usuarioService.saveOrUpdate(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathParam(value = "id") long id) {
		this.usuarioService.deleteById(id);;
	}
	
}

package com.qintess.notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.notes.model.Usuario;
import com.qintess.notes.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@SuppressWarnings("unused") //ainda
	private String criptografaPassword() {
		//criptografar em bcrypt após instalar o security
		return null;
	}
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario saveOrUpdate(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public void delete(Usuario usuario) {
		this.usuarioRepository.deleteById(usuario.getId());
	}
	
	public void deleteById(long id) {
		this.usuarioRepository.deleteById(id);
	}

	public List<Usuario> getAll(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		return this.usuarioRepository.findById(id).get();
	}
	
	public Usuario findByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}
	
	
}

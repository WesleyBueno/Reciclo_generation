package com.reciclo.ecosustentaveis.service;


import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reciclo.ecosustentaveis.model.UserLoginTable;
import com.reciclo.ecosustentaveis.model.UsuarioTable;
import com.reciclo.ecosustentaveis.repository.UsuarioRepository;
@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioTable CadastrarUsuario(UsuarioTable usuario) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	
		String senhaEncoder= encoder.encode(usuario.getUsuarioSenha());
		usuario.setUsuarioSenha(senhaEncoder);
		
		return repository.save(usuario);
	}
	
	public Optional<UserLoginTable> Logar (Optional<UserLoginTable> user){
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		Optional<UsuarioTable> usuario = repository.findByusuarioEmail(user.get().getUsuario());
		
		if(usuario.isPresent()) {
			if(encoder.matches(user.get().getSenha(), usuario.get().getUsuarioSenha())) {
				
				String auth = user.get().getUsuario() + ":"+ user.get().getSenha();			
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
			
				String authHeader= "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setUsuario(usuario.get().getUsuarioEmail());
				
				return user;
			}
		}
		return null;
	}
	
}
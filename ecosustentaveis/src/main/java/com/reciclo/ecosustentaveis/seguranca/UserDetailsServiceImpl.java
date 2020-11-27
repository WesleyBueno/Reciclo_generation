package com.reciclo.ecosustentaveis.seguranca;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reciclo.ecosustentaveis.model.UsuarioTable;
import com.reciclo.ecosustentaveis.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<UsuarioTable> user = userRepository.findByusuarioEmail(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found."));
		return user.map(UserDetailsImpl::new).get();
		
	}
	
}


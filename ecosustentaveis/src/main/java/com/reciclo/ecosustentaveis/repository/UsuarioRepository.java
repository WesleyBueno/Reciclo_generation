package com.reciclo.ecosustentaveis.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclo.ecosustentaveis.model.UsuarioTable;

public interface UsuarioRepository extends JpaRepository<UsuarioTable, Long> {
	

	public Optional<UsuarioTable> findByusuarioEmail(String userName);
	
	@Query(nativeQuery = true,value = "select * from usuario where usuario_email like ?1")
	public UsuarioTable findIdByEmail(String email);
	

	
}

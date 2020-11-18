package com.reciclo.ecosustentaveis.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reciclo.ecosustentaveis.model.UsuarioTable;

public interface UsuarioRepository extends JpaRepository<UsuarioTable, Long> {
	

	public Optional<UsuarioTable> findByusuarioNome(String userName);

	


}

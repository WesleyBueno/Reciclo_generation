package com.reciclo.ecosustentaveis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reciclo.ecosustentaveis.model.UsuarioTable;

public interface UsuarioRepository extends JpaRepository<UsuarioTable, Long> {
	

		List<UsuarioTable> findByusuarioNome(String usuarioNome);

	


}

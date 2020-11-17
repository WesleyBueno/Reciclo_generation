package com.reciclo.ecosustentaveis.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.reciclo.ecosustentaveis.model.CategoriaTable;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaTable, Long> {

	List<CategoriaTable> findBycategoriaNome(String categoriaNome);

	


}
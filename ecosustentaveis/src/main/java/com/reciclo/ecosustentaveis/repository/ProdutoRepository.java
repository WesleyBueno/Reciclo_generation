package com.reciclo.ecosustentaveis.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.reciclo.ecosustentaveis.model.ProdutoTable;


public interface ProdutoRepository extends JpaRepository<ProdutoTable,Long>{
	List<ProdutoTable>findByprodutoNome(String produtoNome);

}

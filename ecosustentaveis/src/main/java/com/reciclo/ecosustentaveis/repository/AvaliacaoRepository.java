package com.reciclo.ecosustentaveis.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reciclo.ecosustentaveis.model.AvaliacaoTable;
	

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoTable,Long> {

	List<AvaliacaoTable> findByAvaliacaoNota(int avaliacaoNota);

	//List<avaliacaoTable> findByIdAvaliacao(Long idAvaliacao);

}

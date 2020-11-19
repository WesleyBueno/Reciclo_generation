package com.reciclo.ecosustentaveis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclo.ecosustentaveis.model.*;

public interface IDetalhePedidoRepository extends JpaRepository<DetalhePedido,DetalhePedidoId>{

	@Query(nativeQuery = true,value = "select * from detalhe_pedido order by produto_preco DESC limit 1")
	DetalhePedido findByPreco();
	
	
}

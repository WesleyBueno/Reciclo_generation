package com.reciclo.ecosustentaveis.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclo.ecosustentaveis.model.*;

public interface IDetalhePedidoRepository extends JpaRepository<DetalhePedido,DetalhePedidoId>{

	@Query(nativeQuery = true,value = "select * from detalhe_pedido order by detalhe_pedido_preco DESC limit 1")
	DetalhePedido findByPreco();
	
	
}

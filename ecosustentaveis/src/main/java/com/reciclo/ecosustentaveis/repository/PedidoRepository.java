package com.reciclo.ecosustentaveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reciclo.ecosustentaveis.model.PedidoTable;

public interface PedidoRepository  extends JpaRepository<PedidoTable, Long>{

}

package com.reciclo.ecosustentaveis.model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class DetalhePedidoId implements Serializable {

	private static final long serialVersionUID = 1L;	

	@Column(name = "produto_id")
	private long produtoId;

	@Column(name="pedido_id")
	private long pedidoId;
	
	public DetalhePedidoId() {}	
	
	public DetalhePedidoId(long produtoId, long pedidoId) {
		this.produtoId = produtoId;
		this.pedidoId = pedidoId;
	}

	public long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}

	public long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(long pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	
	
}

package com.reciclo.ecosustentaveis.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="detalhe_pedido")
public class DetalhePedido {

	@NotNull
	@Column(name = "detalhe_pedido_preco")
	private double pedidoPreco;
	@NotNull
	@Column(name = "detalhe_pedido_qtd")
	private int pedidoQtd;
	
	@EmbeddedId
	private DetalhePedidoId detalhePedidoId;
		
	@ManyToOne
	@MapsId("produto_id")
	@JoinColumn(name = "produto_id")
	@JsonIgnore
	private ProdutoTable produto;
	
	@ManyToOne
	@MapsId("pedido_id")
	@JoinColumn(name = "pedido_id")
	@JsonIgnore
	private PedidoTable pedido;
	
	public ProdutoTable getProduto() {
		return produto;
	}
	public void setProduto(ProdutoTable produto) {
		this.produto = produto;
	}
	public PedidoTable getPedido() {
		return pedido;
	}
	public void setPedido(PedidoTable pedido) {
		this.pedido = pedido;
	}
	public double getPedidoPreco() {
		return pedidoPreco;
	}
	public void setPedidoPreco(double pedidoPreco) {
		this.pedidoPreco = pedidoPreco;
	}
	public int getPedidoQtd() {
		return pedidoQtd;
	}
	public void setPedidoQtd(int pedidoQtd) {
		this.pedidoQtd = pedidoQtd;
	}
	public DetalhePedidoId getDetalhePedidoId() {
		return detalhePedidoId;
	}
	public void setDetalhePedidoId(DetalhePedidoId detalhePedidoId) {
		this.detalhePedidoId = detalhePedidoId;
	}
}

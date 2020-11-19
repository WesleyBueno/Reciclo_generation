package com.reciclo.ecosustentaveis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produto")

public class ProdutoTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long idProduto;
	
	@OneToMany(mappedBy = "produto",cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "produto")
	private List<AvaliacaoTable> avaliacao;
	
	@OneToMany(mappedBy = "produto",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DetalhePedido> detalhePedido;
	
	public ProdutoTable() {}
	
	public List<AvaliacaoTable> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<AvaliacaoTable> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	
	public List<DetalhePedido> getDetalhe() {
		return detalhePedido;
	}

	public void setDetalhe(List<DetalhePedido> detalhe) {
		this.detalhePedido = detalhe;
	}
	
	
}

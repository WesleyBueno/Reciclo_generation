package com.reciclo.ecosustentaveis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="produto")


public class ProdutoTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long idProduto;
	
	@NotNull
	private String produtoFornecedor;
	


	@OneToMany(mappedBy = "produto",cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "produto")

	private List<AvaliacaoTable> avaliacao;
	
	
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
	
	public String getProdutoFornecedor() {
		return produtoFornecedor;
	}

	public void setProdutoFornecedor(String produtoFornecedor) {
		this.produtoFornecedor = produtoFornecedor;
	}
	
}

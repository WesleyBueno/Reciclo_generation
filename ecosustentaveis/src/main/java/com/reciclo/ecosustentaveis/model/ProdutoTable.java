package com.reciclo.ecosustentaveis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produto")
public class ProdutoTable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@Column
	private String produtoNome;
	
	@Column
	private double preco;
	
	@Column
	private String produtoFoto;
	
	@Column
	private String produtoDescricao;
	
	@Column
	private int produtoEstoque;
	
	@Column
	private double produtoPeso;
	
	@ManyToOne
	@JsonIgnoreProperties(value = "produto")
	private CategoriaTable categoria;
	
	

	public ProdutoTable(Long idProduto, String produtoNome, double preco, String produtoFoto, String produtoDescricao,
			int produtoEstoque, double produtoPeso, CategoriaTable categoria) {
		this.idProduto = idProduto;
		this.produtoNome = produtoNome;
		this.preco = preco;
		this.produtoFoto = produtoFoto;
		this.produtoDescricao = produtoDescricao;
		this.produtoEstoque = produtoEstoque;
		this.produtoPeso = produtoPeso;
		this.categoria = categoria;
	}
	

	public ProdutoTable() {
		
		
	}



	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public CategoriaTable getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTable categoria) {
		this.categoria = categoria;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getProdutoFoto() {
		return produtoFoto;
	}

	public void setProdutoFoto(String produtoFoto) {
		this.produtoFoto = produtoFoto;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public int getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(int produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public double getProdutoPeso() {
		return produtoPeso;
	}

	public void setProdutoPeso(double produtoPeso) {
		this.produtoPeso = produtoPeso;
	}

	
}

package com.reciclo.ecosustentaveis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

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
	
	@Column(columnDefinition = "TEXT")
	private String produtoFoto;	
	
	@Column
	private String produtoDescricao;
	
	@Column
	private int produtoEstoque;
	
	@Column
	private double produtoPeso;	
	
	@Column
	private String produtoFornecedor;
		
	@Column
	private String produtoStatus;
	
	@Column
	private String produtoTamanho;
	
	@ManyToOne	
	private CategoriaTable categoria;

	@OneToMany(mappedBy = "produto",cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "produto")
	private List<AvaliacaoTable> avaliacao;		
	
	@OneToMany(mappedBy = "produto",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DetalhePedido> detalhePedido;
	
	public ProdutoTable() {}
	

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

	
	public String getProdutoFornecedor() {
		return produtoFornecedor;
	}

	public void setProdutoFornecedor(String produtoFornecedor) {
		this.produtoFornecedor = produtoFornecedor;
	}
	public List<DetalhePedido> getDetalhe() {
		return detalhePedido;
	}

	public void setDetalhe(List<DetalhePedido> detalhe) {
		this.detalhePedido = detalhe;
	}


	public List<AvaliacaoTable> getAvaliacao() {
		return avaliacao;
	}


	public void setAvaliacao(List<AvaliacaoTable> avaliacao) {
		this.avaliacao = avaliacao;
	}


	public List<DetalhePedido> getDetalhePedido() {
		return detalhePedido;
	}


	public void setDetalhePedido(List<DetalhePedido> detalhePedido) {
		this.detalhePedido = detalhePedido;
	}


	public String getProdutoStatus() {
		return produtoStatus;
	}


	public void setProdutoStatus(String produtoStatus) {
		this.produtoStatus = produtoStatus;
	}


	public String getProdutoTamanho() {
		return produtoTamanho;
	}


	public void setProdutoTamanho(String produtoTamanho) {
		this.produtoTamanho = produtoTamanho;
	}
	
	
}

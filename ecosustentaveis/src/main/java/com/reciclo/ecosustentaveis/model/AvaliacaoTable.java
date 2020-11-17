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
@Table(name="avaliacao")

public class AvaliacaoTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long idAvaliacao;
	
	@Column
	private String avaliacaoComentario;
	
	@Column
	private int avaliacaoNota;

	@ManyToOne	
	@JsonIgnoreProperties(value = "avaliacao")
	
	private ProdutoTable produto;
	@ManyToOne
	@JsonIgnoreProperties(value = "avaliacao")
	
	private UsuarioTable usuario;

	public AvaliacaoTable() {
		
	}
	
	
	public AvaliacaoTable(long idAvaliacao, String avaliacaoComentario, int avaliacaoNota, ProdutoTable produto,
			UsuarioTable usuario) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.avaliacaoComentario = avaliacaoComentario;
		this.avaliacaoNota = avaliacaoNota;
		this.produto = produto;
		this.usuario = usuario;
	}

	public ProdutoTable getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTable produto) {
		this.produto = produto;
	}

	public UsuarioTable getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTable usuario) {
		this.usuario = usuario;
	}

	public long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getAvaliacaoComentario() {
		return avaliacaoComentario;
	}

	public void setAvaliacaoComentario(String avaliacaoComentario) {
		this.avaliacaoComentario = avaliacaoComentario;
	}

	public int getAvaliacaoNota() {
		return avaliacaoNota;
	}

	public void setAvaliacaoNota(int avaliacaoNota) {
		this.avaliacaoNota = avaliacaoNota;
	}
	

	
}

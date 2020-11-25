package com.reciclo.ecosustentaveis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mensagem")

public class Mensagem {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mensagem_id")
	private long mensagemId;
	
	@Column(name = "mensagem_nome")
	private String mensagemNome;
	
	@Column(name = "mensagem_email")
	private String mensagemEmail;
	
	@Column(name = "mensagem_descricao")
	private String mensagemDescricao;
	
	@Column(name = "mensagem_categoria")
	private String mensagemCategoria;

	
	
	public Mensagem() {
	
	}
	

	public Mensagem(long mensagemId, String mensagemNome, String mensagemEmail, String mensagemDescricao,
			String mensagemCategoria) {
		super();
		this.mensagemId = mensagemId;
		this.mensagemNome = mensagemNome;
		this.mensagemEmail = mensagemEmail;
		this.mensagemDescricao = mensagemDescricao;
		this.mensagemCategoria = mensagemCategoria;
	}



	public long getMensagemId() {
		return mensagemId;
	}

	public void setMensagemId(long mensagemId) {
		this.mensagemId = mensagemId;
	}

	public String getMensagemNome() {
		return mensagemNome;
	}

	public void setMensagemNome(String mensagemNome) {
		this.mensagemNome = mensagemNome;
	}

	public String getMensagemEmail() {
		return mensagemEmail;
	}

	public void setMensagemEmail(String mensagemEmail) {
		this.mensagemEmail = mensagemEmail;
	}

	public String getMensagemDescricao() {
		return mensagemDescricao;
	}

	public void setMensagemDescricao(String mensagemDescricao) {
		this.mensagemDescricao = mensagemDescricao;
	}

	public String getMensagemCategoria() {
		return mensagemCategoria;
	}

	public void setMensagemCategoria(String mensagemCategoria) {
		this.mensagemCategoria = mensagemCategoria;
	}
	
	
	

	
	

}

package com.reciclo.ecosustentaveis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Usuario")
public class UsuarioTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long idUsuario;
	
	@Column
	private  String usuarioCpf;
	
	@Column
	private  String usuarioNome;
	
	@Column
	private  String usuarioCel;
	
	@Column(unique = true)
	private  String usuarioEmail;
	
	@Column
	private  String usuarioSenha;
	
	@Column
	private String usuarioTipo;
	
	@Column
	private  String usuarioNascimento;
	
	@Column
	private  String usuarioEndCep;
	
	@Column
	private  String usuarioEndCidade;
	
	@Column
	private  String usuarioEndUf;
	
	@Column
	private  String usuarioEndBairro;

	@Column
	private  String usuarioEndLogradouro;
	
	@Column
	private  String usuarioEndNumero;
	
	@Column
	private  String usuarioEndComplemento;
	

	
	@Column
	private  String usuarioPagDescCartao;
	
	@Column
	private  String usuarioPagNome;
	

	
	@Column
	private  String usuarioPagNumeroCartao;
	
	@Column
	private  String usuarioPagValCartao;
	
	@Column
	private  String usuarioPagCodSeg;
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "usuario")
	private List<AvaliacaoTable> avaliacao;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public String getUsuarioNascimento() {
		return usuarioNascimento;
	}

	public void setUsuarioNascimento(String usuarioNascimento) {
		this.usuarioNascimento = usuarioNascimento;
	}

	public String getUsuarioEndCep() {
		return usuarioEndCep;
	}

	public void setUsuarioEndCep(String usuarioEndCep) {
		this.usuarioEndCep = usuarioEndCep;
	}

	public String getUsuarioEndCidade() {
		return usuarioEndCidade;
	}

	public void setUsuarioEndCidade(String usuarioEndCidade) {
		this.usuarioEndCidade = usuarioEndCidade;
	}

	public String getUsuarioEndUf() {
		return usuarioEndUf;
	}

	public void setUsuarioEndUf(String usuarioEndUf) {
		this.usuarioEndUf = usuarioEndUf;
	}

	public String getUsuarioEndBairro() {
		return usuarioEndBairro;
	}

	public void setUsuarioEndBairro(String usuarioEndBairro) {
		this.usuarioEndBairro = usuarioEndBairro;
	}

	public String getUsuarioEndLogradouro() {
		return usuarioEndLogradouro;
	}

	public void setUsuarioEndLogradouro(String usuarioEndLogradouro) {
		this.usuarioEndLogradouro = usuarioEndLogradouro;
	}

	public String getUsuarioEndNumero() {
		return usuarioEndNumero;
	}

	public void setUsuarioEndNumero(String usuarioEndNumero) {
		this.usuarioEndNumero = usuarioEndNumero;
	}

	public String getUsuarioEndComplemento() {
		return usuarioEndComplemento;
	}

	public void setUsuarioEndComplemento(String usuarioEndComplemento) {
		this.usuarioEndComplemento = usuarioEndComplemento;
	}

	public String getUsuarioCel() {
		return usuarioCel;
	}

	public void setUsuarioCel(String usuarioCel) {
		this.usuarioCel = usuarioCel;
	}

	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public String getUsuarioSenha() {
		return usuarioSenha;
	}

	public void setUsuarioSenha(String usuarioSenha) {
		this.usuarioSenha = usuarioSenha;
	}

	public String getUsuarioPagDescCartao() {
		return usuarioPagDescCartao;
	}

	public void setUsuarioPagDescCartao(String usuarioPagDescCartao) {
		this.usuarioPagDescCartao = usuarioPagDescCartao;
	}

	public String getUsuarioPagNome() {
		return usuarioPagNome;
	}

	public void setUsuarioPagNome(String usuarioPagNome) {
		this.usuarioPagNome = usuarioPagNome;
	}

	public String getUsuarioCpf() {
		return usuarioCpf;
	}

	public void setUsuarioCpf(String usuarioCpf) {
		this.usuarioCpf = usuarioCpf;
	}

	public String getUsuarioPagNumeroCartao() {
		return usuarioPagNumeroCartao;
	}

	public void setUsuarioPagNumeroCartao(String usuarioPagNumeroCartao) {
		this.usuarioPagNumeroCartao = usuarioPagNumeroCartao;
	}

	public String getUsuarioPagValCartao() {
		return usuarioPagValCartao;
	}

	public void setUsuarioPagValCartao(String usuarioPagValCartao) {
		this.usuarioPagValCartao = usuarioPagValCartao;
	}

	public String getUsuarioPagCodSeg() {
		return usuarioPagCodSeg;
	}

	public void setUsuarioPagCodSeg(String usuarioPagCodSeg) {
		this.usuarioPagCodSeg = usuarioPagCodSeg;
	}

	public List<AvaliacaoTable> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<AvaliacaoTable> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setId(Long usuarioId) {
		// TODO Auto-generated method stub
		
	}

	public String getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(String usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}
	
		
	

	
}
	
	
	
	



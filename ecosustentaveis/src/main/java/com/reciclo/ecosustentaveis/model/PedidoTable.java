package com.reciclo.ecosustentaveis.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table (name= "pedido")
public class PedidoTable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long idPedido;
	
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DetalhePedido> detalhePedido;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dataPedido;

	@NotNull
	@Column
	private String formaPagamentoPedido;
	
	@NotNull
	@Column
	private int numParcelasPedido;
	
	@NotNull
	@Column
	@Size (min=10, max= 500)
	private String notaFiscalPedido;
	
	@NotNull
	@Column
	private Double valorFretePedido;
	
	@NotNull
	@Column 
	private int numPedido;
	
	@NotNull
	@Column
	private int opcEntregaPedido;
	
	@NotNull
	@Column
	private Double valorPedido;	
	
	public PedidoTable() {}

	public List<DetalhePedido> getDetalhePedido() {
		return detalhePedido;
	}

	public void setDetalhePedido(List<DetalhePedido> detalhePedido) {
		this.detalhePedido = detalhePedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getFormaPagamentoPedido() {
		return formaPagamentoPedido;
	}

	public void setFormaPagamentoPedido(String formaPagamentoPedido) {
		this.formaPagamentoPedido = formaPagamentoPedido;
	}

	public int getNumParcelasPedido() {
		return numParcelasPedido;
	}

	public void setNumParcelasPedido(int numParcelasPedido) {
		this.numParcelasPedido = numParcelasPedido;
	}

	public String getNotaFiscalPedido() {
		return notaFiscalPedido;
	}

	public void setNotaFiscalPedido(String notaFiscalPedido) {
		this.notaFiscalPedido = notaFiscalPedido;
	}

	public Double getValorFretePedido() {
		return valorFretePedido;
	}

	public void setValorFretePedido(Double valorFretePedido) {
		this.valorFretePedido = valorFretePedido;
	}

	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public int getOpcEntregaPedido() {
		return opcEntregaPedido;
	}

	public void setOpcEntregaPedido(int opcEntregaPedido) {
		this.opcEntregaPedido = opcEntregaPedido;
	}

	public Double getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}

	
	
}

package br.com.indracompany.poc.pedido.endereco.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ADDRESS", schema = "GSIM")
public class EnderecoPedido {

	private long idEnderecoPedido;
	private String nomeEndereco;
	private String endereco1;
	private String endereco2;
	private String endereco3;
	private String endereco4;
	private Timestamp dataCriacao;
	private char delecaoLogica;
	private long tipoEndereco;
	private String descricao;
	private String preferencial;

	@Id
	@Column(name = "ID_ORDER_ADDRESS", unique = true, nullable = false, precision = 10)
	public long getIdEnderecoPedido() {
		return idEnderecoPedido;
	}
	public void setIdEnderecoPedido(long idEnderecoPedido) {
		this.idEnderecoPedido = idEnderecoPedido;
	}

	@Column(name = "NAME", unique = false, nullable = false, length = 256)
	public String getNomeEndereco() {
		return nomeEndereco;
	}
	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}

	@Column(name = "ADDRESS1", unique = false, nullable = false, length = 256)
	public String getEndereco1() {
		return endereco1;
	}
	public void setEndereco1(String endereco1) {
		this.endereco1 = endereco1;
	}

	@Column(name = "ADDRESS2", unique = false, nullable = false, length = 256)
	public String getEndereco2() {
		return endereco2;
	}
	public void setEndereco2(String endereco2) {
		this.endereco2 = endereco2;
	}

	@Column(name = "ADDRESS3", unique = false, nullable = false, length = 256)
	public String getEndereco3() {
		return endereco3;
	}
	public void setEndereco3(String endereco3) {
		this.endereco3 = endereco3;
	}

	@Column(name = "ADDRESS4", unique = false, nullable = false, length = 256)
	public String getEndereco4() {
		return endereco4;
	}
	public void setEndereco4(String endereco4) {
		this.endereco4 = endereco4;
	}

	@Column(name = "DATE_NEW", unique = false, nullable = false)
	public Timestamp getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "LOGICAL_DELETE", unique = false, nullable = false, length = 1)
	public char getDelecaoLogica() {
		return delecaoLogica;
	}
	public void setDelecaoLogica(char delecaoLogica) {
		this.delecaoLogica = delecaoLogica;
	}

	@Column(name = "TYPE", unique = false, nullable = false, precision = 10)
	public long getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(long tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	@Column(name = "DESCRIPTION", unique = false, nullable = true, length = 255)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "PREFERENTIAL", unique = false, nullable = true, length = 1)
	public String getPreferencial() {
		return preferencial;
	}
	public void setPreferencial(String preferencial) {
		this.preferencial = preferencial;
	}

}

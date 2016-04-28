package br.com.indracompany.poc.pedido.endereco.to;

import java.sql.Timestamp;
import java.util.Date;

import br.com.indracompany.poc.pedido.endereco.entity.EnderecoPedido;

public class EnderecoPedidoTO {

	private long idEnderecoPedido;
	private String nomeEndereco;
	private String endereco1;
	private String endereco2;
	private String endereco3;
	private String endereco4;
	private Date dataCriacao;
	private char delecaoLogica;
	private long tipoEndereco;
	private String descricao;
	private String preferencial;

	public EnderecoPedidoTO(EnderecoPedido endereco){
		this.idEnderecoPedido = endereco.getIdEnderecoPedido();
		this.nomeEndereco = endereco.getNomeEndereco();
		this.endereco1 = endereco.getEndereco1();
		this.endereco2 = endereco.getEndereco2();
		this.endereco3 = endereco.getEndereco3();
		this.endereco4 = endereco.getEndereco4();
		if (endereco.getDataCriacao() != null){
			this.dataCriacao = new Date(endereco.getDataCriacao().getTime());
		}
		this.delecaoLogica = endereco.getDelecaoLogica();
		this.tipoEndereco = endereco.getTipoEndereco();
		this.descricao = endereco.getDescricao();
		this.preferencial = endereco.getPreferencial();
	}

	public EnderecoPedidoTO(){
	}

	public long getIdEnderecoPedido() {
		return idEnderecoPedido;
	}
	public void setIdEnderecoPedido(long idEnderecoPedido) {
		this.idEnderecoPedido = idEnderecoPedido;
	}
	public String getNomeEndereco() {
		return nomeEndereco;
	}
	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}
	public String getEndereco1() {
		return endereco1;
	}
	public void setEndereco1(String endereco1) {
		this.endereco1 = endereco1;
	}
	public String getEndereco2() {
		return endereco2;
	}
	public void setEndereco2(String endereco2) {
		this.endereco2 = endereco2;
	}
	public String getEndereco3() {
		return endereco3;
	}
	public void setEndereco3(String endereco3) {
		this.endereco3 = endereco3;
	}
	public String getEndereco4() {
		return endereco4;
	}
	public void setEndereco4(String endereco4) {
		this.endereco4 = endereco4;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public char getDelecaoLogica() {
		return delecaoLogica;
	}
	public void setDelecaoLogica(char delecaoLogica) {
		this.delecaoLogica = delecaoLogica;
	}
	public long getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(long tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreferencial() {
		return preferencial;
	}
	public void setPreferencial(String preferencial) {
		this.preferencial = preferencial;
	}

}

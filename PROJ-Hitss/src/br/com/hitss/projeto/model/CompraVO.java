package br.com.hitss.projeto.model;

import java.io.Serializable;
import java.util.Date;

public class CompraVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6867417913107272575L;
	private String nomeComprador;
	private String emailComprador;
	private String telefoneComprador;
	private Date dataCompra;
	private Integer quantidade;
	private Integer idProduto;
	private String cidadeComprador;

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public String getEmailComprador() {
		return emailComprador;
	}

	public void setEmailComprador(String emailComprador) {
		this.emailComprador = emailComprador;
	}

	public String getTelefoneComprador() {
		return telefoneComprador;
	}

	public void setTelefoneComprador(String telefoneComprador) {
		this.telefoneComprador = telefoneComprador;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getCidadeComprador() {
		return cidadeComprador;
	}

	public void setCidadeComprador(String cidadeComprador) {
		this.cidadeComprador = cidadeComprador;
	}

}

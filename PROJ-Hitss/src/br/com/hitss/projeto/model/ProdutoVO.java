package br.com.hitss.projeto.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase responsável por mapear os atributos(capacidades) que um produto possui.
 * 
 * @author Eduardo Martins
 *
 */
public class ProdutoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7265753837535183495L;
	private Integer id;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private Date data_inclusao;
	private Date data_ultima_alteracao;
	private String usuario;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Date getData_ultima_alteracao() {
		return data_ultima_alteracao;
	}

	public void setData_ultima_alteracao(Date data_ultima_alteracao) {
		this.data_ultima_alteracao = data_ultima_alteracao;
	}

}

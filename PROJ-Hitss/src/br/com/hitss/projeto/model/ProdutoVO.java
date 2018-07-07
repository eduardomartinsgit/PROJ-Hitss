package br.com.hitss.projeto.model;

import java.io.Serializable;

/**
 * Clase responsável por mapear os atributos(capacidades) que um produto possui.
 * 
 * @author Eduardo Martins
 *
 */
public class ProdutoVO implements Serializable	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7265753837535183495L;
	private Integer id;
	private String nomeProduto;
	private Double precoProduto;
	private Integer quantidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}

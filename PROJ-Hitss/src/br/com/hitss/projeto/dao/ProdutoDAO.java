package br.com.hitss.projeto.dao;

import java.text.ParseException;
import java.util.List;

import br.com.hitss.projeto.model.CompraVO;
import br.com.hitss.projeto.model.ProdutoVO;

/**
 * Interface responsável por estabelecer uma relação contratual das operações que poderão ser manuseadas com os produtos.
 * @author Eduardo Martins
 *
 */
public interface ProdutoDAO {

	/**
	 * Método responsável por incluir um novo produto no estoque.
	 * @param pedido
	 */
	public void incluirProduto(ProdutoVO produto);
	
	/**
	 * Método responsável por obter um produto a partir de seu nome(descrição).
	 * @param nomeProduto
	 * @return
	 */
	public ProdutoVO obterProduto(String nomeProduto);
	
	/**
	 * Método responsável por obter todos os produtos cadastrados no estoque.
	 * @param produtosAtivos - Flag responsável por controlar se o método retornará apenas pedidos ativos
	 * @return
	 * @throws ParseException 
	 */
	public List<ProdutoVO> obterTodosProdutos(boolean produtosAtivos);
	
	/**
	 * Método responsável por atualizar as informações de um determinado produto.
	 * @param produto
	 */
	public void atualizarProduto(ProdutoVO produto);
	
	/**
	 * Método responsável por remover um produto do estoque.
	 * @param produto
	 */
	public void removerProduto(ProdutoVO produto);
	
	/**
	 * Método responsável por realizar a compra de um determinado produto disponivel no estoque.
	 * @param produto
	 */
	public void comprarProduto(CompraVO compra);
}

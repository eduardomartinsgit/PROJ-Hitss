package br.com.hitss.projeto.dao;

import java.text.ParseException;
import java.util.List;

import br.com.hitss.projeto.model.CompraVO;
import br.com.hitss.projeto.model.ProdutoVO;

/**
 * Interface respons�vel por estabelecer uma rela��o contratual das opera��es que poder�o ser manuseadas com os produtos.
 * @author Eduardo Martins
 *
 */
public interface ProdutoDAO {

	/**
	 * M�todo respons�vel por incluir um novo produto no estoque.
	 * @param pedido
	 */
	public void incluirProduto(ProdutoVO produto);
	
	/**
	 * M�todo respons�vel por obter um produto a partir de seu nome(descri��o).
	 * @param nomeProduto
	 * @return
	 */
	public ProdutoVO obterProduto(String nomeProduto);
	
	/**
	 * M�todo respons�vel por obter todos os produtos cadastrados no estoque.
	 * @param produtosAtivos - Flag respons�vel por controlar se o m�todo retornar� apenas pedidos ativos
	 * @return
	 * @throws ParseException 
	 */
	public List<ProdutoVO> obterTodosProdutos(boolean produtosAtivos);
	
	/**
	 * M�todo respons�vel por atualizar as informa��es de um determinado produto.
	 * @param produto
	 */
	public void atualizarProduto(ProdutoVO produto);
	
	/**
	 * M�todo respons�vel por remover um produto do estoque.
	 * @param produto
	 */
	public void removerProduto(ProdutoVO produto);
	
	/**
	 * M�todo respons�vel por realizar a compra de um determinado produto disponivel no estoque.
	 * @param produto
	 */
	public void comprarProduto(CompraVO compra);
}

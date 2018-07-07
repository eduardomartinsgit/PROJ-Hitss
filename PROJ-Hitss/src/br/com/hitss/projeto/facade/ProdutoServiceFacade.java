package br.com.hitss.projeto.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hitss.projeto.dao.ProdutoDAO;
import br.com.hitss.projeto.model.ProdutoVO;


@Component
public class ProdutoServiceFacade {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	public ProdutoVO obterProduto(String nomeProduto)
	{
		
		return produtoDAO.obterProduto(nomeProduto);		
		
	}
}

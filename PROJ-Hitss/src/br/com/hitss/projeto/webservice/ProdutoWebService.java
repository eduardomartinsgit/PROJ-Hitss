package br.com.hitss.projeto.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hitss.projeto.dao.ProdutoDAO;
import br.com.hitss.projeto.model.ProdutoVO;

/**
 * Classe responsável por prover os serviços de inclusão, remoção, busca, atualização e compra de produtos.
 * @author Eduardo Martins
 *
 */
@Path("/produto")
public class ProdutoWebService {	
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GET
	@Path("/obterProduto")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoVO obterPedido(@QueryParam("nomeProduto") String nomeProduto) {
		
		ProdutoVO produto = produtoDAO.obterProduto(nomeProduto);
		return produto;
	}
	
}

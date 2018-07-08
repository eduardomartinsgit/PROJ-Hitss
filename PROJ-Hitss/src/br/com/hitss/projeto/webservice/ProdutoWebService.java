package br.com.hitss.projeto.webservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	public ProdutoVO obterProduto(@QueryParam("nomeProduto") String nomeProduto) {
		
		ProdutoVO produto = produtoDAO.obterProduto(nomeProduto);
		return produto;
	}
	
	@GET
	@Path("/obterProdutos")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoVO> obterProdutos(@QueryParam("produtosAtivos") boolean produtosAtivos) {
		
		List<ProdutoVO> produtos = null;
		produtos = produtoDAO.obterTodosProdutos(produtosAtivos);
		return produtos;
	}	
	
	@POST
	@Path("/incluirProduto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> incluirProduto(@QueryParam("nome") String nomeProduto, @QueryParam("preco") String precoProduto, @QueryParam("quantidade") String quantidade, @QueryParam("usuario") String usuario, @QueryParam("status") String statusProduto) {
		
		List<String> erros = new ArrayList<>();
		
		validarCampos(nomeProduto, precoProduto, quantidade, usuario, statusProduto, erros);			
		
		if(!erros.isEmpty()) {
			return erros;
		}
		
		ProdutoVO produto = popularDados(nomeProduto, precoProduto, quantidade, usuario, statusProduto);
		produto.setData_inclusao(new Date());
		
		produtoDAO.incluirProduto(produto);
		
		return erros;
	}

	@PUT
	@Path("/alterarProduto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> alterarProduto(@QueryParam("nome") String nomeProduto, @QueryParam("preco") String precoProduto, @QueryParam("quantidade") String quantidade, @QueryParam("usuario") String usuario, @QueryParam("status") String statusProduto, @QueryParam("id") String idProduto) {
		
		List<String> erros = new ArrayList<>();
		validarCampos(nomeProduto, precoProduto, quantidade, usuario, statusProduto, erros);			
		
		if(!erros.isEmpty()) {
			return erros;
		}
		
		ProdutoVO produto = popularDados(nomeProduto, precoProduto, quantidade, usuario, statusProduto);
		produto.setId(new Integer(idProduto));
		produtoDAO.atualizarProduto(produto);
		
		return erros;
	}	
	
	@DELETE
	@Path("/removerProduto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void removerProduto(@QueryParam("id") String idProduto) {

		ProdutoVO produto = new ProdutoVO();
		produto.setId(new Integer(idProduto));
		produtoDAO.removerProduto(produto);
		
	}
	
	
	private ProdutoVO popularDados(String nomeProduto, String precoProduto, String quantidade, String usuario,String statusProduto) {
		ProdutoVO produto = new ProdutoVO();
		produto.setNome(nomeProduto);
		produto.setPreco(new Double(precoProduto.replaceAll(",", ".")));
		Double qntProdutos = new Double(quantidade.replaceAll(",", "."));
		qntProdutos = Double.valueOf(Math.round(qntProdutos.doubleValue()));
		produto.setQuantidade(new Integer(qntProdutos.intValue()));
		produto.setData_ultima_alteracao(new Date());
		produto.setUsuario(usuario);
		produto.setStatus(statusProduto);
		return produto;
	}

	private void validarCampos(String nomeProduto, String precoProduto, String quantidade, String usuario,
			String statusProduto, List<String> erros) {
		if(nomeProduto == null || nomeProduto.isEmpty()) {
			erros.add("O campo Nome do Produto deve ser preenchido!");
		}
		if(precoProduto == null || precoProduto.isEmpty()) {
			erros.add("O campo Preço do Produto deve ser preenchido!");
		}		
		if(quantidade == null || quantidade.isEmpty()) {
			erros.add("O campo Quantidade deve ser preenchido!");
		}	
		if(usuario == null || usuario.isEmpty()) {
			erros.add("O campo Usuario deve ser preenchido!");
		}		
		if(statusProduto == null || statusProduto.isEmpty()) {
			erros.add("O campo Status do Produto deve ser preenchido!");
		}
	}
	
}

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
import br.com.hitss.projeto.model.CompraVO;
import br.com.hitss.projeto.model.ProdutoVO;
import br.com.hitss.projeto.queue.producer.MessageSender;

/**
 * Classe responsável por prover os serviços de inclusão, remoção, busca, atualização e compra de produtos.
 * @author Eduardo Martins
 *
 */
@Path("/produto")
public class ProdutoWebService {	
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
    MessageSender messageSender;
	
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
		
		validarCamposProduto(nomeProduto, precoProduto, quantidade, usuario, statusProduto, erros);			
		
		if(!erros.isEmpty()) {
			return erros;
		}
		
		ProdutoVO produto = popularDados(nomeProduto, precoProduto, quantidade, usuario, statusProduto);
		produto.setData_inclusao(new Date());
		
		return erros;
	}

	@PUT
	@Path("/alterarProduto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> alterarProduto(@QueryParam("nome") String nomeProduto, @QueryParam("preco") String precoProduto, @QueryParam("quantidade") String quantidade, @QueryParam("usuario") String usuario, @QueryParam("status") String statusProduto, @QueryParam("id") String idProduto) {
		
		List<String> erros = new ArrayList<>();
		validarCamposProduto(nomeProduto, precoProduto, quantidade, usuario, statusProduto, erros);			
		
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
	
	@POST
	@Path("/comprarProduto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> comprarProduto(@QueryParam("nomeComprador") String nomeComprador, @QueryParam("emailComprador") String emailComprador, @QueryParam("quantidade") Integer quantidade, @QueryParam("cidadeComprador") String cidadeComprador, @QueryParam("telefoneComprador") String telefoneComprador) {
		
		List<String> erros = new ArrayList<>();
		
		validarCamposCompra(nomeComprador, emailComprador, quantidade, cidadeComprador, telefoneComprador, erros);			
		
		if(!erros.isEmpty()) {
			return erros;
		}
		
		CompraVO compra = popularDados(nomeComprador, emailComprador, quantidade, cidadeComprador, telefoneComprador);
		compra.setDataCompra(new Date());
		
		messageSender.sendMessage(compra);
		
		return erros;
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
	
	private CompraVO popularDados(String nomeComprador, String emailComprador, Integer quantidade, String cidadeComprador, String telefoneComprador) {
		CompraVO compra = new CompraVO();
		compra.setNomeComprador(nomeComprador);
		compra.setEmailComprador(emailComprador);
		compra.setQuantidade(quantidade);
		compra.setTelefoneComprador(telefoneComprador);
		compra.setCidadeComprador(cidadeComprador);
		return compra;
	}

	private void validarCamposProduto(String nomeProduto, String precoProduto, String quantidade, String usuario,
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

	
	private void validarCamposCompra(String nomeComprador, String emailComprador, Integer quantidade, String cidadeComprador, String telefoneComprador, List<String> erros) {
		if(nomeComprador == null || nomeComprador.isEmpty()) {
			erros.add("O campo Nome do Produto deve ser preenchido!");
		}
		if(emailComprador == null || emailComprador.isEmpty()) {
			erros.add("O campo Preço do Produto deve ser preenchido!");
		}		
		if(quantidade == null || quantidade.equals(new Integer(0))) {
			erros.add("O campo Quantidade deve ser preenchido!");
		}	
		if(cidadeComprador == null || cidadeComprador.isEmpty()) {
			erros.add("O campo Usuario deve ser preenchido!");
		}		
		if(telefoneComprador == null || telefoneComprador.isEmpty()) {
			erros.add("O campo Status do Produto deve ser preenchido!");
		}
	}	
	
}

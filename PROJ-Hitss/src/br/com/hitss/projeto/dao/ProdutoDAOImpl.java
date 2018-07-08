package br.com.hitss.projeto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.hitss.projeto.model.CompraVO;
import br.com.hitss.projeto.model.ProdutoVO;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO{

	private static final Logger LOGGER = Logger.getLogger(ProdutoDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	public synchronized void incluirProduto(ProdutoVO produto) {
		LOGGER.debug("INSERINDO O PRODUTO NO ESTOQUE: " + produto.getNome());
		jdbcTemplate.update("INSERT INTO Produtos (nome, preco, quantidade, data_inclusao, data_ultima_alteracao, usuario, status) VALUES (?, ?, ?, ?, ?, ?, ?)", new Object[] { produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getData_inclusao(), produto.getData_inclusao(), produto.getUsuario(), produto.getStatus()});
	}

	public ProdutoVO obterProduto(String nomeProduto) {
		ProdutoVO produtos = jdbcTemplate.queryForObject("SELECT P.id, P.nome, P.preco, P.quantidade, P.data_inclusao, P.data_ultima_alteracao, P.usuario FROM Produtos P WHERE P.nome = " + nomeProduto, new ProdutoRowMapper());	
		return produtos;
	}

	public List<ProdutoVO> obterTodosProdutos(boolean produtosAtivos) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT P.id, P.nome, P.preco, P.quantidade, P.data_inclusao, P.data_ultima_alteracao, P.usuario FROM Produtos P");
		if(produtosAtivos) {
			query.append(" WHERE P.status = 'A'");
		}
		List<ProdutoVO> produtos = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<>(ProdutoVO.class));
		return produtos;
	}

	public synchronized void atualizarProduto(ProdutoVO produto) {
		LOGGER.debug("ATUALIZANDO O PRODUTO NO ESTOQUE: " + produto.getNome());
		jdbcTemplate.update("UPDATE Produtos SET nome = ?, preco = ?, quantidade = ?, data_ultima_alteracao = ?, usuario = ?, status = ? WHERE id = ?", new Object[] { produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getData_ultima_alteracao(), produto.getUsuario(), produto.getStatus(), produto.getId()});		
	}

	public synchronized void removerProduto(ProdutoVO produto) {
		LOGGER.debug("REMOVENDO O PRODUTO DO ESTOQUE: " + produto.getNome());
		jdbcTemplate.update("UPDATE Produtos SET status = 'I' WHERE id = ?", new Object[] {produto.getId()});
	}

	public synchronized void comprarProduto(CompraVO compra) {
		LOGGER.debug("REALIZANDO COMPRA DO PRODUTO - ID: " + compra.getIdProduto() + " QUANTIDADE: " + compra.getQuantidade());
		
		jdbcTemplate.update("UPDATE Produtos SET quantidade = ? WHERE id = ?", new Object[] { compra.getQuantidade(), compra.getIdProduto() });
		jdbcTemplate.update("INSERT INTO Compras (nome_comprador, email_comprador, telefone, data_compra, id_produto, quantidade) VALUES (?, ?, ?, ?, ?, ?);", new Object[] {compra.getNomeComprador(), compra.getEmailComprador(), compra.getTelefoneComprador(), compra.getDataCompra(), compra.getIdProduto(), compra.getQuantidade() });
		
	}

	private class ProdutoRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProdutoVO produto = new ProdutoVO();
			produto.setId(rs.getInt("id"));
			produto.setNome(rs.getString("nome"));
			produto.setPreco(rs.getDouble("preco"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setData_inclusao(rs.getDate("data_inclusao"));
			produto.setData_ultima_alteracao(rs.getDate("data_ultima_alteracao"));
			produto.setUsuario(rs.getString("usuario"));
			return produto;
		}
		
	}	

}

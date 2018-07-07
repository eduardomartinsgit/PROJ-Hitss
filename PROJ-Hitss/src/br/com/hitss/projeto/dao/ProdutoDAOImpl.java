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

import br.com.hitss.projeto.model.ProdutoVO;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO{

	private static final Logger LOGGER = Logger.getLogger(ProdutoDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public void incluirPedido(ProdutoVO pedido) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	public ProdutoVO obterProduto(String nomeProduto) {
		ProdutoVO produtos = jdbcTemplate.queryForObject("SELECT P.id, P.nome, P.preco, P.quantidade, P.data_inclusao, P.data_ultima_alteracao, P.usuario FROM Produtos P WHERE P.nome = " + nomeProduto, new ProdutoRowMapper());
		return produtos;
	}

	public List<ProdutoVO> obterTodosProdutos() {
		List<ProdutoVO> produtos = jdbcTemplate.query("SELECT P.id, P.nome, P.preco, P.quantidade, P.data_inclusao, P.data_ultima_alteracao, P.usuario FROM Produtos P", new BeanPropertyRowMapper<>(ProdutoVO.class));
		return produtos;
	}

	@Override
	public void atualizarProduto(ProdutoVO produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerProduto(ProdutoVO produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comprarProduto(ProdutoVO produto) {
		// TODO Auto-generated method stub
		
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

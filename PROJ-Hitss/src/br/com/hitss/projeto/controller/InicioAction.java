package br.com.hitss.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.hitss.projeto.dao.ProdutoDAO;
import br.com.hitss.projeto.model.ProdutoVO;
@Controller
public class InicioAction {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("pagina-inicial");
		
		List<ProdutoVO> produtos = produtoDAO.obterTodosProdutos(true);
		
		mv.addObject("produtos", produtos);	
		return mv;
	}
	
}

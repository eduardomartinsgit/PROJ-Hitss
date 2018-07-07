package br.com.hitss.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {

	@RequestMapping("/")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("inicio");
		return mv;
	}
	
}

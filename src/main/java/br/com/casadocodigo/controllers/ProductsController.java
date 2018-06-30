package br.com.casadocodigo.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.dao.ProductDAO;
import br.com.casadocodigo.models.BookType;
import br.com.casadocodigo.models.Product;

@Controller
@Transactional
@RequestMapping(value="/produtos") 
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("produtos/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
		
	}
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");	
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView save(Product product, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:produtos");
		redirectAttributes.addFlashAttribute("sucesso", "Livro " + product.getTitle() + " salvo com sucesso");
		productDAO.save(product);
		return modelAndView;
	}

}

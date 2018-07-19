package br.com.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	/*
	 * Metódo usado para iniciar o validador da classe Product, não usado mais.
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}
	*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("produtos/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
		
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("produtos/form");	
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)	
	public ModelAndView save(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView("redirect:produtos");
		
		if(bindingResult.hasErrors()) {
			return form(product);
		}
		
		redirectAttributes.addFlashAttribute("sucesso", "Livro " + product.getTitle() + " salvo com sucesso");
		productDAO.save(product);
		return modelAndView;
	}

}

package br.com.casadocodigo.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.dao.ProductDAO;
import br.com.casadocodigo.models.Product;

@Controller
@Transactional
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}
	
	
	@RequestMapping("/produtos")	
	public String save(Product product) {
		productDAO.save(product);
		return "produtos/ok";
	}

}

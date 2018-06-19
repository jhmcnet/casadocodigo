package br.com.casadocodigo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.controllers.HomeController;
import br.com.casadocodigo.dao.ProductDAO;
//Objetivo principal é expor para a Servlet do Spring quais as classes que devem ser lidas e carregadas

@EnableWebMvc //habilita funcionalidades usadas na aplicacao
@ComponentScan(basePackageClasses= {HomeController.class,ProductDAO.class}) //pacotes devem ser lidos
public class AppWebConfiguration {	
	
	@Bean //retorno do metodo deve ser gerenciado como um objeto gerenciado pelo container
	public InternalResourceViewResolver internalResourceViewResolver() { //configuracoes da pasta base, prefixo e sufixo que devem ser adicionados a qualquer caminho retornado por metodos dos controllers
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}


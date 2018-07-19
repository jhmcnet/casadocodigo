package br.com.casadocodigo.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
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
	@Bean // indica o local do arquivo de mensagens
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
				
	}
	
	@Bean //configurando de forma global a conversao de datas
	public FormattingConversionService mvcConversionService() {
		
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
		registrar.registerFormatters(conversionService);
		
		return conversionService;
	}

}


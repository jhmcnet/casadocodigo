package br.com.casadocodigo.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//Mapea os controllers e outras classes a serem carregadas pelo container,
		//retorna uma ou mais classes que indicam outras que devem ser lidas durante o carregamento
		return new Class[] {AppWebConfiguration.class,JPAConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		//Define padrao de endereco delegado ao Servlet do Spring MVC
		return new String[] {"/"};
	}

}

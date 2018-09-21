package com.ad.arquitectura.init;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.ad.arquitectura.config.*;
public class SpringWebInitializer implements WebApplicationInitializer {
	
	public void onStartup(ServletContext contenedor) throws ServletException{
		
		AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
		contexto.register(ConfiguracionSrping.class);
		//spring con la web
		contexto.setServletContext(contenedor);
		
		ServletRegistration.Dynamic servlet = contenedor.addServlet("dispatcher", new DispatcherServlet(contexto));
		
		contenedor.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForServletNames(null, false, "/*");
		
	}
}

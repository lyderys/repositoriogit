package com.atos.jdbc.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Acceso_Manolo implements ApplicationContextAware {
	private static ApplicationContext ctx;
	
	


	public void setApplicationContext(ApplicationContext ctx) throws BeansException{
		Acceso_Manolo.ctx=ctx;
	}
	
	public static ApplicationContext getCtx() {
		return ctx;
	}
	
	public static Object getBean(String objeto) {
		return ctx.getBean(objeto);
	}
	
	public static <T>T getBean(Class<T> spring_bean){
		return ctx.getBean(spring_bean);
	}
	
}

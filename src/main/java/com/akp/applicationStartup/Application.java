package com.akp.applicationStartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.akp.controller","com.akp.configuration"})
public class Application {
	
	
	public static void main(String[] args) {
		/*ApplicationContext ctx =*/ SpringApplication.run(Application.class, args);
		
	/*	@Bean
	    public EmbeddedServletContainerFactory servletContainer() {
	        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	        factory.setPort(9000);
	        factory.setSessionTimeout(10, TimeUnit.MINUTES);
	        //factory.addErrorPages(new ErrorPage(HttpStatus.404, "/notfound.html"));
	        return factory;
	    }*/

		System.out.println("Let's inspect the beans provided by Spring Boot:");

	}

}

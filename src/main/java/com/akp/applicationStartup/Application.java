package com.akp.applicationStartup;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.akp.controller","com.akp.configuration"})
public class Application {
	
	static ApplicationContext ctx = null;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SpringApplication application= new  SpringApplication();
	ApplicationContext ctx=	SpringApplication.run(Application.class,args);
		
		application.setShowBanner(false);
				System.out.println("Let's inspect the beans provided by Spring Boot:");

			
				String[] beanNames = ctx.getBeanDefinitionNames();
		        Arrays.sort(beanNames);
		        for (String beanName : beanNames) {
		            System.out.println(beanName);
	}

}
}
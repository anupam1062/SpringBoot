package com.akp.configuration;	

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
@Override
public void addViewControllers(ViewControllerRegistry registry){
registry.addViewController("/login").setViewName("Ologin");
registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
}

/*@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/css/**").addResourceLocations("classpath:resources/css/");
    registry.addResourceHandler("/images/**").addResourceLocations("classpath:resources/images/");
    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
}*/
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}

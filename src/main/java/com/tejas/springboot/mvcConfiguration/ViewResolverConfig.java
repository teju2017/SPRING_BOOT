package com.tejas.springboot.mvcConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ViewResolverConfig implements WebMvcConfigurer{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		
		FreeMarkerViewResolver freemarker = new FreeMarkerViewResolver();
		freemarker.setCache(true);
		freemarker.setOrder(0);
		freemarker.setPrefix("templates/ftl/");
		freemarker.setSuffix(".ftl");
		freemarker.setContentType("text/html;charset=UTF-8");
		registry.viewResolver(freemarker);

		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(thymeleafTemplateEngine());
		resolver.setOrder(1);
		String[] abc = { "abc.html", "admin.html", "error.html", "extUser.html", "user.html" };
		resolver.setViewNames(abc);
		registry.viewResolver(resolver);

		
		

		System.out.println("View resolver registry is executed");

	}

	@Bean
	ISpringTemplateEngine thymeleafTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
		return templateEngine;
	}

	@Bean
    ITemplateResolver thymeleafTemplateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setOrder(1);
		return templateResolver;
	}

	@Bean
	FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("templates/ftl/");
		return configurer;
	}

	@Bean
	public SpringResourceTemplateResolver springResourceTemplateResolver() {
		return new SpringResourceTemplateResolver();
	}

}

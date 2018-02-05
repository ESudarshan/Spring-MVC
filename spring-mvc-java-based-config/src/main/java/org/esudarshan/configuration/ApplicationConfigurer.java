package org.esudarshan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({ "org.esudarshan" })
@EnableWebMvc
public class ApplicationConfigurer extends WebMvcConfigurerAdapter {

	@Bean
	InternalResourceViewResolver getInteralResourceViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
}

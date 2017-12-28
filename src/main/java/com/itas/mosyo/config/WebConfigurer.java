package com.itas.mosyo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.itas.mosyo.converter.StringListToColorListConverter;
import com.itas.mosyo.converter.StringToProductConverter;

@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }

    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	
        registry.addConverter(stringListToColorListConverter());
        registry.addConverter(stringToProductConverter());
    
    }
    
    @Bean
    public StringListToColorListConverter stringListToColorListConverter(){
    
    	return new StringListToColorListConverter();
    	
    }
    
    @Bean
    public StringToProductConverter stringToProductConverter(){
    	
    	return new StringToProductConverter();
    	
    }
    
}

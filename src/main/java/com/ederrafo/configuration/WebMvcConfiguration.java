package com.ederrafo.configuration;

import com.ederrafo.component.RequestTimeInterceptorComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*
 * Esta clase es una configuracion de spring mvc
 * la extendemos de WebMvcConfigurerAdapter
 * Here we register our interceptor class for Spring recognize and configure it.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {


    @Autowired
    @Qualifier("requestTimeInterceptorComponent")
    private RequestTimeInterceptorComponent requestTimeInterceptorComponent;




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // We add our interceptor for Spring configure it
        registry.addInterceptor(requestTimeInterceptorComponent);
        //super.addInterceptors(registry);

    }
}

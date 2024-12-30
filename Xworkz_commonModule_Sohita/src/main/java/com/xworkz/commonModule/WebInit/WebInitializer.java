package com.xworkz.commonModule.WebInit;

import com.xworkz.commonModule.configuration.ModuleConfiguration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("invoking getRootConfigClasses..");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("invoking in the getServletConfigClasses..");
        return new Class[] {ModuleConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("invoking in the getServletMappings..");
        return new String[]{"/"};
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}


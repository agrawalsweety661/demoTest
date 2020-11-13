package com.java.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringConfiguration.class };
    }
  
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
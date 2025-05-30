package com.luv2code.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer; 


import com.luv2code.entity.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
    private String theAllowedOrigins = "https://bookish-fortnight-x7wqw5vxv7ph97vv-3000.app.github.dev";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PATCH, HttpMethod.DELETE, HttpMethod.PUT};
        config.exposeIdsFor(Book.class);
        disableHttpMethods(Book.class, config, theUnsupportedActions);
        cors.addMapping(config.getBasePath() + "/**")
        .allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class<?> theClass, RepositoryRestConfiguration config,
            HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass)
        .withItemExposure((metdata, HttpMethods) ->
        HttpMethods.disable(theUnsupportedActions))
        .withCollectionExposure((metdata, HttpMethods) ->
        HttpMethods.disable(theUnsupportedActions));
    }
}

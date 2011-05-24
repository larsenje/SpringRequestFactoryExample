package com.example.testapp;

import com.google.gwt.requestfactory.shared.ServiceLocator;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringServiceLocator implements ServiceLocator {

  public Object getInstance(Class<?> clazz) {
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(MyRequestFactory.getThreadLocalServletContext().get());
    return context.getBean(clazz);
  }

}

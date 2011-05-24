package com.example.testapp;

import com.google.gwt.requestfactory.server.RequestFactoryServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyRequestFactory extends RequestFactoryServlet {

  private static final ThreadLocal<ServletContext> perServletContext = new ThreadLocal<ServletContext>();

  public static ThreadLocal<ServletContext> getThreadLocalServletContext() {
    return perServletContext;
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    perServletContext.set(getServletContext());
    try {
      super.doPost(request, response);
    } finally {
      perServletContext.set(null);
    }
  }

}

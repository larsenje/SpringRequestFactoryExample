package com.example.client;

import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.google.gwt.requestfactory.shared.Service;

import com.example.testapp.HelloWorldService;
import com.example.testapp.SpringServiceLocator;

public interface MyRf extends RequestFactory {

  @Service(value = HelloWorldService.class, locator = SpringServiceLocator.class)
  public interface SayHello extends RequestContext {
    Request<Void> printHello(HelloProxy proxy);
  }

  SayHello getHelloMaker();

}

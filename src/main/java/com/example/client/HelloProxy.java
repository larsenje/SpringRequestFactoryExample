package com.example.client;

import com.google.gwt.requestfactory.shared.ProxyFor;
import com.google.gwt.requestfactory.shared.ValueProxy;

import com.example.testapp.Hello;

@ProxyFor(Hello.class)
public interface HelloProxy extends ValueProxy {

  String getMessage();

  void setMessage(String message);

}

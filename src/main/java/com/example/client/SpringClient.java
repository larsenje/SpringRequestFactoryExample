package com.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.ServerFailure;
import com.google.gwt.user.client.Window;

import com.example.client.MyRf.SayHello;

public class SpringClient implements EntryPoint {

  public void onModuleLoad() {
    EventBus bus = new SimpleEventBus();
    MyRf rf = GWT.create(MyRf.class);
    rf.initialize(bus);

    SayHello helloMaker = rf.getHelloMaker();

    HelloProxy proxy = helloMaker.create(HelloProxy.class);
    proxy.setMessage("Hello World Client");
    rf.initialize(new SimpleEventBus());
    helloMaker.printHello(proxy).fire(new Receiver<Void>() {

      @Override
      public void onFailure(ServerFailure error) {
        Window.alert("failure");
        super.onFailure(error);
      }

      @Override
      public void onSuccess(Void response) {
        Window.alert("Success");
      }
    });

  }
}

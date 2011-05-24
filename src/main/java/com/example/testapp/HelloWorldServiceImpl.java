package com.example.testapp;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

  public void printHello(Hello hello) {
    System.out.println(hello.getMessage());
  }
}

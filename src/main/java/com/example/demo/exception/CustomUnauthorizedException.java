package com.example.demo.exception;

/**
 * Created by M93349 on 2020/8/20.
 */
public class CustomUnauthorizedException extends RuntimeException{
  public CustomUnauthorizedException(String msg){
    super(msg);
  }

  public CustomUnauthorizedException() {
    super();
  }
}

package com.example.demo.exception;

/**
 * Created by M93349 on 2020/8/20.
 */
public class CustomException extends RuntimeException {
  public CustomException(String msg){
    super(msg);
  }

  public CustomException() {
    super();
  }
}

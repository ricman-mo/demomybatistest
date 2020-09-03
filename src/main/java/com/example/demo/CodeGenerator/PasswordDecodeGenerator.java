package com.example.demo.CodeGenerator;

import com.example.demo.util.AesCipherUtil;

/**
 * Created by M93349 on 2020/8/21.
 */
public class PasswordDecodeGenerator {
  public static void main(String[] args){
    String password = AesCipherUtil.enCrypto("adminadmin");
    System.out.println(password);
  }
}

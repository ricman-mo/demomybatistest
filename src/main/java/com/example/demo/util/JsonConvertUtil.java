package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by M93349 on 2020/8/20.
 */
public class JsonConvertUtil {
  private JsonConvertUtil() {}

  /**
   * JSON 转 Object
   */
  public static <T> T jsonToObject(String pojo, Class<T> clazz) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(pojo,clazz);
  }

  /**
   * Object 转 JSON
   */
  public static <T> String objectToJson(T t) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(t);
  }
}

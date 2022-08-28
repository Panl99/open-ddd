package com.only4play.security.exception;

public class ParseTokenException extends RuntimeException{

  public ParseTokenException(Integer code,String msg){
    super(msg);
    this.code = code;
    this.msg = msg;
  }
  private Integer code;

  private String msg;

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}

package com.RamenGo.api.exceptions;

public class InternalServerErrorException extends RuntimeException{
  public InternalServerErrorException(String message){
    super(message);
  }
}

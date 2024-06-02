package com.RamenGo.api.exceptions;

public class InvalidRequestException extends RuntimeException{
  public InvalidRequestException(String message){
    super(message);
  }
}

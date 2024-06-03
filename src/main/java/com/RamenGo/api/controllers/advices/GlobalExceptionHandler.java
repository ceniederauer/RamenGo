package com.RamenGo.api.controllers.advices;

import com.RamenGo.api.dtos.responses.ErrorResponse;
import com.RamenGo.api.exceptions.ForbbidenException;
import com.RamenGo.api.exceptions.InternalServerErrorException;
import com.RamenGo.api.exceptions.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MissingRequestHeaderException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ErrorResponse handleForbbidenException(MissingRequestHeaderException exception) {
    return new ErrorResponse("x-api-key header missing");
  }

  @ExceptionHandler(ForbbidenException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ErrorResponse handleForbbidenException(ForbbidenException exception) {
    return new ErrorResponse("unauthorized");
  }

  @ExceptionHandler(InternalServerErrorException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleInternalServerErrorException(InternalServerErrorException exception) {
    return new ErrorResponse(exception.getMessage());
  }

  @ExceptionHandler(InvalidRequestException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleInvalidRequestException(InvalidRequestException exception) {
    return new ErrorResponse(exception.getMessage());
  }
}

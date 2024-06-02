package com.RamenGo.api.dtos.requests;

import lombok.Data;

@Data
public class OrderRequest {
  private String brothId;
  private String proteinId;

  public OrderRequest(String number, String number1) {
  }
}

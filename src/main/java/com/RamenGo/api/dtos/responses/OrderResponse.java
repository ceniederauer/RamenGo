package com.RamenGo.api.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
  private String id;
  private String description;
  private String image;
}
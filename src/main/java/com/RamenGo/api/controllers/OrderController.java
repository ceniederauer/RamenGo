package com.RamenGo.api.controllers;

import com.RamenGo.api.dtos.requests.OrderRequest;
import com.RamenGo.api.dtos.responses.OrderResponse;
import com.RamenGo.api.exceptions.ForbbidenException;
import com.RamenGo.api.models.Broth;
import com.RamenGo.api.models.Protein;
import com.RamenGo.api.services.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class OrderController {

  private final OrderService orderService;
  private String apiKey = "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf";

  @GetMapping("/broths")
  public ResponseEntity<List<Broth>> broths(@RequestHeader("x-api-key") String apiKey) {
    if (apiKey.equals(this.apiKey)) {
      return new ResponseEntity<>(this.orderService.listBroths(), HttpStatus.OK);
    }
    throw new ForbbidenException("x-api-key header missing");
  }

  @GetMapping("/proteins")
  public ResponseEntity<List<Protein>> proteins(@RequestHeader("x-api-key") String apiKey) {
    if (apiKey.equals(this.apiKey)) {
      return new ResponseEntity<>(this.orderService.listProteins(), HttpStatus.OK);
    }
    throw new ForbbidenException("x-api-key header missing");
  }

  @PostMapping("/orders")
  public ResponseEntity<OrderResponse> order(
      @RequestHeader("x-api-key") String apiKey,
      @RequestBody OrderRequest orderRequest) throws JsonProcessingException {
    if (apiKey.equals(this.apiKey)) {
      return this.orderService.createOrder(orderRequest, apiKey);
    }
    throw new ForbbidenException("x-api-key header missing");
  }
}

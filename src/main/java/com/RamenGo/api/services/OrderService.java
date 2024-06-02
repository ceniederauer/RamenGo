package com.RamenGo.api.services;

import com.RamenGo.api.dtos.requests.OrderRequest;
import com.RamenGo.api.dtos.responses.OrderResponse;
import com.RamenGo.api.exceptions.InternalServerErrorException;
import com.RamenGo.api.exceptions.InvalidRequestException;
import com.RamenGo.api.models.Broth;
import com.RamenGo.api.models.Protein;
import com.RamenGo.api.repositories.BrothRepository;
import com.RamenGo.api.repositories.ProteinRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final ProteinRepository proteinRepository;
  private final BrothRepository brothRepository;
  private final RestClient restClient;

  public List<Protein> listProteins() {
    return proteinRepository.findAll();
  }
  public List<Broth> listBroths() {
    return brothRepository.findAll();
  }

  public ResponseEntity<OrderResponse> createOrder(OrderRequest orderRequest, String apiKey) throws JsonProcessingException {
    if (ObjectUtils.isEmpty(orderRequest.getBrothId()) || ObjectUtils.isEmpty(orderRequest.getProteinId())) {
      throw new InvalidRequestException("both brothId and proteinId are required");
    }
    String generateOrder = restClient.post()
        .uri("https://api.tech.redventures.com.br/orders/generate-id")
        .header("x-api-key", apiKey)
        .retrieve()
        .body(String.class);
    if(generateOrder.isEmpty()){
      throw new InternalServerErrorException("could not place order");
    }
    // Parse the JSON string
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(generateOrder);
    String orderId = jsonNode.get("orderId").asText();
    OrderResponse order = OrderResponse.builder()
        .id(orderId)
        .description(buildOrderDescription(orderRequest))
        .image("image")
        .build();

    return new ResponseEntity<>(order, HttpStatus.CREATED);
  }

  public String buildOrderDescription(OrderRequest orderRequest) {
    String brothName = brothRepository.findNameById(orderRequest.getBrothId());
    String proteinName = proteinRepository.findNameById(orderRequest.getProteinId());
    return brothName + " and " + proteinName + " Ramen";
  }
}

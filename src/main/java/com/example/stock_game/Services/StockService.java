//A service is part of the business logic layer of your application. It contains the application's core logic and
//coordinates different components. Services DO NOT handle HTTP requests or directly communicate with clients.
//Services can call repositories for database interaction or make API calls to external services. They help maintain
//a separation of concerns by abstracting business logic away from the controllers.
package com.example.stock_game.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {
    private final RestTemplate restTemplate;

    @Value("${twelvedata.api.key}")
    private String api_key;

    public StockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStockData(String symbol) {
        String url = "https://api.twelvedata.com/v2/stocks/" + symbol + "&interval=1min&apikey=" + api_key;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();

    }

}

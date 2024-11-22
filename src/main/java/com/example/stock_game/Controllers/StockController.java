package com.example.stock_game.Controllers;

import com.example.stock_game.Services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Combines @Controller and @ResponseBody. This indicates that the class handles web requests and that
//the return values of methods are directly written to the http response body (e.g. JSON)
@RequestMapping("/api/stocks") //Specifies the bas URL for all the endpoints in this controller
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<String> getStock(@PathVariable String symbol) {
        String data = stockService.getStockData(symbol);
        return ResponseEntity.ok(data);
    }
}

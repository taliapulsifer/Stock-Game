package com.example.stock_game.Controllers;

import com.example.stock_game.Models.StockHistory;
import com.example.stock_game.Models.StockInfo;
import com.example.stock_game.Services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<StockInfo> getStock(@PathVariable String symbol) {
        try {
            StockInfo stockInfo = stockService.getStockData(symbol);
            return ResponseEntity.ok(stockInfo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/history/{symbol}")
    public ResponseEntity<List<StockHistory.StockHistoryData.StockDataPoint>> getStockHistory(@PathVariable String symbol) {
        try {
            StockHistory stockHistory = stockService.getStockHistory(symbol);
            StockHistory.StockHistoryData historyData = stockHistory.getData().get(symbol);

            if (historyData != null) {
                return ResponseEntity.ok(historyData.getValues());
            } else {
                return ResponseEntity.status(404).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/buy")
    public ResponseEntity<Map<String, Object>> postStockBuy(
            @RequestParam String symbol,
            @RequestParam int quantity,
            @RequestParam double price
    ) {
        try {
            Map<String, Object> response = stockService.buyStock(symbol, quantity, price);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/sell")
    public ResponseEntity<Map<String, Object>> postStockSell(
            @RequestParam String symbol,
            @RequestParam int quantity
    ) {
        Map<String, Object> response = stockService.sellStock(symbol, quantity);
        return ResponseEntity.ok(response);
    }
}
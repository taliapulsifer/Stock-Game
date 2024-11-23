package com.example.stock_game.Models;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, OwnershipDetails> stocks;
    private String userID;

    public Portfolio() {
        this.stocks = new HashMap<>();
    }

    public void removeStock(String stockID) {
        stocks.remove(stockID);
    }

    public void addStock(String stockID, int quantity, double purchasePrice, StockInfo stockInfo) {
        if(stocks.containsKey(stockID)) {
            OwnershipDetails ownershipDetails = stocks.get(stockID);
            ownershipDetails.setQuantity(ownershipDetails.getQuantity() + quantity);
            ownershipDetails.setPurchasePrice(purchasePrice);
        }
        else{
            stocks.put(stockID, new OwnershipDetails(quantity, purchasePrice, stockInfo));
        }
    }

    public OwnershipDetails getStock(String stockID) {
        return stocks.get(stockID);
    }

    public void listStocks() {
        for (Map.Entry<String, OwnershipDetails> entry : stocks.entrySet()) {
            System.out.println("Stock: " + entry.getKey() + ", " + entry.getValue());
        }
    }

    // Inner class for stock ownership details
    public static class OwnershipDetails {
        private int quantity;
        private double purchasePrice;
        private StockInfo stockInfo;

        public OwnershipDetails(int quantity, double purchasePrice, StockInfo stockInfo) {
            this.quantity = quantity;
            this.purchasePrice = purchasePrice;
            this.stockInfo = stockInfo;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPurchasePrice() {
            return purchasePrice;
        }

        public void setPurchasePrice(double purchasePrice) {
            this.purchasePrice = purchasePrice;
        }

        public StockInfo getStockInfo() {
            return stockInfo;
        }

        @Override
        public String toString() {
            return "Quantity: " + quantity +
                    ", Purchase Price: " + purchasePrice +
                    ", Stock Info: " + stockInfo;
        }
    }
}

package com.example.stock_game.Models;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockHistory {
    private Map<String, StockHistoryData> data;  // Store stock data for multiple symbols

    // Getter for stock data
    public Map<String, StockHistoryData> getData() {
        return data;
    }

    // Nested class for the stock's history data
    public static class StockHistoryData {
        private List<StockDataPoint> values;

        public List<StockDataPoint> getValues() {
            return values;
        }

        public void setValues(List<StockDataPoint> values) {
            this.values = values;
        }

        // Nested class to represent each data point
        public static class StockDataPoint {
            private String datetime;
            private String open;
            private String high;
            private String low;
            private String close;
            private String volume;

            // Constructor
            public StockDataPoint(String datetime, String open, String high, String low, String close, String volume) {
                this.datetime = datetime;
                this.open = open;
                this.high = high;
                this.low = low;
                this.close = close;
                this.volume = volume;
            }

            // Getters
            public String getDatetime() {
                return datetime;
            }

            public String getOpen() {
                return open;
            }

            public String getHigh() {
                return high;
            }

            public String getLow() {
                return low;
            }

            public String getClose() {
                return close;
            }

            public String getVolume() {
                return volume;
            }
        }
    }
}
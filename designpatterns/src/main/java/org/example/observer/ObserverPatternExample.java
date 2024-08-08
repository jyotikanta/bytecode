package org.example.observer;

import java.util.HashMap;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockData stockData = new StockData();
        Observer stockDisplay1 = new StockDisplay("Display1");
        Observer stockDisplay2 = new StockDisplay("Display2");
        Observer stockAlert = new StockAlert();
        Observer stockLogger = new StockLogger("ConsoleLogger");

        stockData.addObserver(stockDisplay1);
        stockData.addObserver(stockDisplay2);
        stockData.addObserver(stockAlert);
        stockData.addObserver(stockLogger);

        stockData.setStockPrice("APPL", 98.5);
        stockData.setStockPrice("APPL", 213.12);
    }
}

package org.example.observer;

public class StockAlert implements Observer{
    @Override
    public void update(String stockSymbol, double price) {
        if(price>100){
            System.out.println("Alert " + stockSymbol + " price crossed threshold: " + price);
        }
    }
}

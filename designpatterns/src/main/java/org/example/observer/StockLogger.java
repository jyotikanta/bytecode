package org.example.observer;

public class StockLogger implements Observer{
    private String name;

    public StockLogger(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(name+ " logging stock price : " + stockSymbol + " - " + price);
    }
}

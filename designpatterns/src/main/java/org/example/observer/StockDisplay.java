package org.example.observer;

public class StockDisplay implements Observer{
    private String name;

    public StockDisplay(String name){
        this.name=name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(name+ " display updated : " + stockSymbol + " - " + price);
    }
}

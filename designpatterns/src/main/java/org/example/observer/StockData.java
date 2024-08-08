package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class StockData implements Subject{
    List<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String stockSymbol, double price) {
        for(Observer observer: observers){
            observer.update(stockSymbol,price);
        }
    }

    public void setStockPrice(String stockSymbol, double price){
        System.out.println("Stock price of " + stockSymbol + " updated to " + price);
        notifyObserver(stockSymbol,price);
    }
}

package com.rental;
import java.util.Observable;

public class ObservableDayChange extends Observable{
    private int day = 0;
    public ObservableDayChange(){
        this.day = 0;
    }
    public void dayChange(){
        this.day++;
        setChanged();
        notifyObservers();
    }
    public int getDay(){
        return day;
    }
}

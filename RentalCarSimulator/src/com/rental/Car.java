package com.rental;

public interface Car {
    String getType();
    int getRate();
    String getPlate();
    boolean isRented();
    int getDaysLeft();
    void setDaysLeft(int days);
    void setRented(boolean rented);
    void decreaseDaysLeft();
    
}

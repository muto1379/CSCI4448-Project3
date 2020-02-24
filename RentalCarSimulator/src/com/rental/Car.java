package com.rental;

public interface Car {
    String getType();
    int getRate();
    String getPlate();
    boolean isRented();
    void setRented(boolean rented);
}

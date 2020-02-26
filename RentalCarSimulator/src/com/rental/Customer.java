package com.rental;

import java.util.Random;

public interface Customer {
    String getName();
    String getCustomerType();
    int getRentals();
    int getDaysPerRental();

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

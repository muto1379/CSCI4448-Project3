package com.rental;

import java.util.Random;

public class RegularCustomer implements Customer {
    private String name;
    private String customerType;
    private int rentals;

    public RegularCustomer(String name) {
        this.name = name;
        customerType="Regular";
        rentals = getRandomNumberInRange(1,3);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    @Override
    public int getRentals(){
        System.out.println(rentals);
        return rentals;
    }

    @Override
    public String getCustomerType() {
        System.out.println(customerType);
        return customerType;
    }


    @Override
    public String getName() {
        System.out.println(name);
        return name;
    }


}

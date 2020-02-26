package com.rental;

import java.util.Random;

public class RegularCustomer implements Customer {
    private String name;
    private String customerType;
    private int carRentals;
    private int daysCarIsRented;

    public RegularCustomer(String name) {
        this.name = name;
        customerType="Regular";
        carRentals = Customer.getRandomNumberInRange(1,3);
        daysCarIsRented=Customer.getRandomNumberInRange(3,5);
    }




    @Override
    public int getRentals(){
//        System.out.println(carRentals);
        return carRentals;
    }

    @Override
    public String getCustomerType() {
//        System.out.println(customerType);
        return customerType;
    }


    @Override
    public String getName() {
//        System.out.println(name);
        return name;
    }

    @Override
    public int getDaysPerRental(){
//        System.out.println("Car can be rented "+Integer.toString(daysCarIsRented)+" days");
        return daysCarIsRented;
    }



}

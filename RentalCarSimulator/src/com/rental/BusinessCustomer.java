package com.rental;

public class BusinessCustomer implements Customer {
    private String name;
    private String customerType;
    private int carRentals;
    private int daysCarIsRented;

    public BusinessCustomer(String name) {
        this.name = name;
        customerType="Business";
        carRentals = 3;
        daysCarIsRented=7;
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

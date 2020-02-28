package com.rental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RentalRecord {
    private String customerName;
    private String customerType;
    private String carType;
    private String carLicensePlate;
    private boolean rentalStatus;
    private int lengthOfRental;
    private int dailyRentalRate;

    RentalRecord(Customer customer, Car car){
        customerName=customer.getName();
        customerType=customer.getCustomerType();
        carType=car.getType();
        carLicensePlate=car.getPlate();
        car.setRented(true);
        rentalStatus=car.isRented();
        lengthOfRental=customer.getDaysPerRental();
        dailyRentalRate=car.getRate();
    }


    public void printRecord() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Customer type: " + customerType);
        System.out.println("Car being rented: " + carType);
        System.out.println("Car license plate: " + carLicensePlate);
        System.out.println("Car rented? "+Boolean.toString(rentalStatus));
        System.out.println("Length of rental: " + Integer.toString(lengthOfRental));
        System.out.println("Daily rate of rental: " + Integer.toString(dailyRentalRate));
        System.out.println("Total cost of rental: "+Integer.toString(totalCostCalculator(dailyRentalRate, lengthOfRental)));
    }

    public int totalCostCalculator(int dailyRate, int lengthOfRental){

        return(dailyRate*lengthOfRental);
    }

}


package com.rental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RentalRecord {

    public void createRecord(Customer customer, Car car) {
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer type: " + customer.getCustomerType());
        System.out.println("Car being rented: " + car.getType());
        System.out.println("Car license plate: " + car.getPlate());
        car.setRented(true);
        System.out.println("Car rented? "+Boolean.toString(car.isRented()));
        System.out.println("Length of rental: " + customer.getDaysPerRental());
        System.out.println("Daily rate of rental: " + car.getRate());
        System.out.println("Total cost of rental: "+Integer.toString(totalCostCalculator(car.getRate(),customer.getDaysPerRental())));
    }

    public int totalCostCalculator(int dailyRate, int lengthOfRental){

        return(dailyRate*lengthOfRental);
    }

}


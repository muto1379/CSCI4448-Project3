package com.rental;

import java.util.Observer;
import java.util.Observable;

public class RentalRecord implements Observer{
    private String customerName;
    private String customerType;
    private String carType;
    private String carLicensePlate;
    private boolean rentalStatus;
    private int lengthOfRental;
    private int dailyRentalRate;
    private Car car;
    private boolean returned;
    private int daysLeft;
    private ObservableDayChange ov = null;
    private Customer customer;
    private int baseCost;
    private int totalCost;

    RentalRecord(Customer customer, Car car, ObservableDayChange ov){
        this.customer = customer;
        customerName=customer.getName();
        customerType=customer.getCustomerType();
        carType=car.getType();
        carLicensePlate=car.getPlate();
        car.setRented(true);
        rentalStatus=car.isRented();
        lengthOfRental=customer.getDaysPerRental();
        dailyRentalRate=car.getRate();
        this.car = car;
        returned = false;
        daysLeft = lengthOfRental;
        this.ov = ov;

        CostCalculator bCost = new TCost(dailyRentalRate, lengthOfRental);
        baseCost = bCost.TotalCost(dailyRentalRate, lengthOfRental);
        CostCalculator tCost = new newTotalCost(new TCost(dailyRentalRate, lengthOfRental));
        totalCost = tCost.TotalCost(dailyRentalRate, lengthOfRental);

    }

    public void update(Observable obs, Object obj){
        if (obs == ov) {
            daysLeft--;
        }

    }

    public int getTotalCost(){
        return totalCost;
    }

    public boolean getReturned(){
        return returned;
    }
    public int getDaysLeft(){
        return daysLeft;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Car getCar()
    {
        return this.car;
    }

    public void setReturned(boolean returned)
    {
        this.returned = returned;
        car.setRented(false);
        rentalStatus = false;
    }

    public void printRecord() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Customer type: " + customerType);
        System.out.println("Car being rented: " + carType);
        System.out.println("Car license plate: " + carLicensePlate);
        //System.out.println("Car rented? "+Boolean.toString(rentalStatus));
        System.out.println("Length of rental: " + Integer.toString(lengthOfRental));
        System.out.println("Daily rate of rental: " + Integer.toString(dailyRentalRate));

//        CostCalculator bCost = new TCost(dailyRentalRate, lengthOfRental);
//        int baseCost = bCost.TotalCost(dailyRentalRate, lengthOfRental);
//        CostCalculator tCost = new newTotalCost(new TCost(dailyRentalRate, lengthOfRental));
//        int totalCost = tCost.TotalCost(dailyRentalRate, lengthOfRental);

        System.out.println("Base cost of rental: "+Integer.toString(baseCost));
        System.out.println("Total cost of rental: "+Integer.toString(totalCost));
        System.out.println("Returned: " + this.returned);
    }
}


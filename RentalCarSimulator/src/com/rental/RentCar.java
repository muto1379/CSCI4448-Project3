package com.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RentCar {
    private int carsRented;
    private List<RentalRecord> records = new ArrayList<RentalRecord>();
    private ObservableDayChange observable;
    private int totalSales;


    public RentCar()
    {
        observable = new ObservableDayChange();
        totalSales = 0;
    }
    public void dayChange(CarInventory inven){
        observable.dayChange();

        for(RentalRecord rental_current : records){ //Check if any cars have 0 days left, and should be returned

            if (rental_current.getDaysLeft() <= 0 && rental_current.getReturned() == false){
                ReturnCar(rental_current.getCustomer(), inven);

                observable.deleteObserver(rental_current);

                System.out.println("Returning Customer: " + rental_current.getCustomerName() + "Car: " + rental_current.getCar());
            }
        }
    }
    public void Rent(Customer cust, CarInventory inven)
    {
        Random rand = new Random();
        carsRented = cust.getRentals();
        int randNum = 0;
        if(carsRented <= inven.getCarsInventory().size())
        {
            for (int i = 0; i < carsRented; i++)
            {
                randNum = rand.nextInt(inven.getCarsInventory().size());
                Car carRent = inven.getCarsInventory().get(randNum);
                inven.rentCar(carRent);
                //RentalRecord rec = new RentalRecord(cust, carRent);
                RentalRecord record_new = new RentalRecord(cust, carRent, observable);
                records.add(record_new);

                totalSales += record_new.getTotalCost();
                observable.addObserver(record_new);

            }
        }
        else
        {
            System.out.println("Not enough cars to rent!");
        }

    }

    public int getTotalSales() {
        return totalSales;
    }

    public List<RentalRecord> getRecords()
    {
        return records;
    }

    public void printRecords()
    {
        for(int i = 0; i < records.size(); i++)
        {
            records.get(i).printRecord();
            System.out.println('\n');
        }
    }
    public void ReturnCar(Customer cust, CarInventory inven)
    {
        for(int i = 0; i < records.size(); i++)
        {
            if(records.get(i).getCustomerName().equals(cust.getName()))
            {
                inven.returnCar(records.get(i).getCar());
                records.get(i).setReturned(true);
            }
        }
    }
}

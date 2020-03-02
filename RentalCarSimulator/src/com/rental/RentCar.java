package com.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RentCar {
    private int carsRented;
    private List<RentalRecord> records = new ArrayList<RentalRecord>();


    public RentCar()
    {

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
                records.add(new RentalRecord(cust, carRent));
            }
        }
        else
        {
            System.out.println("Not enough cars to rent!");
        }

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

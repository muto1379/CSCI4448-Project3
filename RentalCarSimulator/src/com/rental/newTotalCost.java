package com.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class newTotalCost extends CostDecorator
{
    public newTotalCost(CostCalculator optionalCost) {
        super(optionalCost);
    }

    @Override
    public int TotalCost(int dailyRentalRate, int lengthOfRental)
    {
        int newTotal = optionalCost.TotalCost(dailyRentalRate, lengthOfRental);
        newTotal = newCosts(newTotal);
        return newTotal;
    }

    private int newCosts(int newTotal)
    {
        int GPS = 50;
        int satRadio = 15;
        int carSeats = 30;
        Random rand = new Random();
        int GPSNum = rand.nextInt(2);
        int satRadioNum = rand.nextInt(2);
        int carSeatNum = rand.nextInt(5);
        newTotal = newTotal + (GPSNum * GPS) + (satRadioNum * satRadio) + (carSeatNum * carSeats);
        return newTotal;
    }

}

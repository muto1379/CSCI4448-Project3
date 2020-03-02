package com.rental;

public abstract class CostDecorator implements CostCalculator {
    protected CostCalculator optionalCost;

    public CostDecorator(CostCalculator optionalCost)
    {
        this.optionalCost = optionalCost;
    }

    public int TotalCost(int dailyRentalRate, int lengthOfRental)
    {
        int totalCost = optionalCost.TotalCost(dailyRentalRate, lengthOfRental);
        return totalCost;
    }
}


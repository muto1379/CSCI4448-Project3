package com.rental;

class TCost implements CostCalculator {
    int dailyRentalRate;
    int lengthOfRental;
    public TCost(int dailyRentalRate, int lengthOfRental) {
        this.dailyRentalRate = dailyRentalRate;
        this.lengthOfRental = lengthOfRental;

    }

    @Override
    public int TotalCost(int dailyRentalRate, int lengthOfRental) {
        int totalCost = dailyRentalRate * lengthOfRental;
        return totalCost;
    }
}

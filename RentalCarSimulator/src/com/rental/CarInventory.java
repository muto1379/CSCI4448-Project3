package com.rental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarInventory
{
    private List<Car> allCars = new ArrayList<Car>();
    private List<Car> carInInventory = new ArrayList<Car>();
    private List<Car> carRented = new ArrayList<Car>();

    public CarInventory()
    {

    }

    public void addCar(Car car)
    {
        car.setRented(false);
        carInInventory.add(car);
        allCars.add(car);
    }

    public void rentCar(Car car)
    {
        car.setRented(true);
        carRented.add(car);
        carInInventory.remove(car);
    }

    public void returnCar(Car car)
    {
        car.setRented(false);
        carRented.remove(car);
        carInInventory.add(car);
    }

    public void printAllCars()
    {
        System.out.println("Number total of cars: " + allCars.size());
        for(int i = 0; i < allCars.size(); i++)
        {
            System.out.println("Car license plate: " + allCars.get(i).getPlate());
            System.out.println("Car type: " + allCars.get(i).getType());
            System.out.println("Car being rented? " + allCars.get(i).isRented());
            System.out.println("Daily rental rate: " + allCars.get(i).getRate());
            System.out.println('\n');
        }
    }

    public void printCarsInventory()
    {
        System.out.println("Number of cars in inventory: " + carInInventory.size());
        for(int i = 0; i < carInInventory.size(); i++)
        {
            System.out.println("Car license plate: " + carInInventory.get(i).getPlate());
            System.out.println("Car type: " + carInInventory.get(i).getType());
            System.out.println("Car being rented? " + carInInventory.get(i).isRented());
            System.out.println("Daily rental rate: " + carInInventory.get(i).getRate());
            System.out.println('\n');
        }
    }

    public void printCarsRented()
    {
        System.out.println("Number of cars rent: " + carRented.size());
        for(int i = 0; i < carRented.size(); i++)
        {
            System.out.println("Car license plate: " + carRented.get(i).getPlate());
            System.out.println("Car type: " + carRented.get(i).getType());
            System.out.println("Car being rented? " + carRented.get(i).isRented());
            //System.out.println("Rented for :" + carRented.get(i).rentDays());
            System.out.println("Daily rental rate: " + carRented.get(i).getRate());
            System.out.println('\n');
        }
    }
}

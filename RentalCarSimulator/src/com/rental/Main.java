package com.rental;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //instantiate car factory
        CarFactory carFactory = new CarFactory();

        //create list of cars in the fleet
        List<Car> carFleet = new ArrayList<Car>();

        //creates 25 cars in the fleet, 5 of each kind and adds them to carFleet list
        for(int i=0; i<5; i++){
            Car economy = carFactory.getCar("economy");
            carFleet.add(economy);

            Car standard = carFactory.getCar("standard");
            carFleet.add(standard);

            Car suv = carFactory.getCar("suv");
            carFleet.add(suv);

            Car luxury = carFactory.getCar("luxury");
            carFleet.add(luxury);

            Car minivan = carFactory.getCar("minivan");
            carFleet.add(minivan);
        }

        //remove the last element to meet assignment requirements of 24 total cars in rental catalog
        //specifically, this leaves 5 of each category of car EXCEPT Minivan which will have 4 total cars in the fleet
        carFleet.remove(carFleet.size() - 1);

        //just loop through to see type, daily rate, and license plate of each car
        for(Car car : carFleet){
            car.getType();
            car.getRate();
            car.getPlate();
            car.isRented();
        }
    }
}

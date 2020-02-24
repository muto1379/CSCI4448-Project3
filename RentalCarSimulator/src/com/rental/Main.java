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
            carFleet.add(standard);

            Car luxury = carFactory.getCar("luxury");
            carFleet.add(luxury);

            Car minivan = carFactory.getCar("minivan");
            carFleet.add(minivan);
        }

        //just loop through to see type, daily rate, and license plate of each car
        for(Car car : carFleet){
            car.getType();
            car.getRate();
            car.getPlate();
        }

    }
}

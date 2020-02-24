package com.rental;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CarFactory carFactory = new CarFactory();
        for(int i=0; i<5; i++){
            Car economy = carFactory.getCar("economy");
            economy.getType();
            economy.getRate();
            economy.getPlate();

            Car standard = carFactory.getCar("standard");
            standard.getType();
            standard.getRate();
            standard.getPlate();

            Car suv = carFactory.getCar("suv");
            suv.getType();
            suv.getRate();
            suv.getPlate();

            Car luxury = carFactory.getCar("luxury");
            luxury.getType();
            luxury.getRate();
            luxury.getPlate();

            Car minivan = carFactory.getCar("minivan");
            minivan.getType();
            minivan.getRate();
            minivan.getPlate();
        }


//        Car car1 = carFactory.getCar("economy");
//        car1.getType();
//        car1.getRate();
//        Car car2 = carFactory.getCar("suv");
//        car2.getType();
//        car2.getRate();

    }
}

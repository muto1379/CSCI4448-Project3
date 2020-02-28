package com.rental;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //instantiate car factory
        CarFactory carFactory = new CarFactory();

        //create list of cars in the fleet
        List<Car> carFleet = new ArrayList<Car>();
        //create a list of customers that will rent cars
        List<Customer> customerList = new ArrayList<Customer>();

        //creates 25 cars in the fleet, 5 of each kind and adds them to carFleet list


        for (int i = 0; i < 5; i++) {
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

        //Instantiate all of the customers and add them to a customer list
        Customer Becca = new BusinessCustomer("Becca");
        customerList.add(Becca);
        Customer Bryan = new BusinessCustomer("Bryan");
        customerList.add(Bryan);
        Customer Bridget = new BusinessCustomer("Bridget");
        customerList.add(Bridget);
        Customer Brandon = new BusinessCustomer("Brandon");
        customerList.add(Brandon);

        Customer Carrie = new CasualCustomer("Carrie");
        customerList.add(Carrie);
        Customer Carlos = new CasualCustomer("Carlos");
        customerList.add(Carlos);
        Customer Christine = new CasualCustomer("Christine");
        customerList.add(Christine);
        Customer Cory = new CasualCustomer("Cory");
        customerList.add(Cory);

        Customer Ryan = new RegularCustomer("Ryan");
        customerList.add(Ryan);
        Customer Rachel = new RegularCustomer("Rachel");
        customerList.add(Rachel);
        Customer Richard = new RegularCustomer("Richard");
        customerList.add(Richard);
        Customer Ruth = new RegularCustomer("Ruth");
        customerList.add(Ruth);

        //check info about customers w simple print statement
//        for(Customer c:customerList){
//            c.getName();
//            c.getRentals();
//            c.getCustomerType();
//            c.getDaysPerRental();
//
//        }

        for (int i = 0; i < 3; i++){
            Random rand = new Random();
            Customer randomCustomer = customerList.get(rand.nextInt(customerList.size()));
            Car randomCar = carFleet.get(rand.nextInt(carFleet.size()));
            RentalRecord r = new RentalRecord(randomCustomer, randomCar);
            r.printRecord();
            System.out.println('\n');
        }

        //just loop through to see type, daily rate, and license plate of each car
//        for(Car car : carFleet){
//            car.getType();
//            car.getRate();
//            car.getPlate();
//            car.isRented();
//        }
    }
}

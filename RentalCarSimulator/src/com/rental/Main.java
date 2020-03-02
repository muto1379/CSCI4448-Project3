package com.rental;

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
        //create car inventory
        CarInventory inventory = new CarInventory();

        //creates 25 cars in the fleet, 5 of each kind and adds them to carFleet list


        for (int i = 0; i < 5; i++) {
            Car economy = carFactory.getCar("economy");
            carFleet.add(economy);
            inventory.addCar(economy);

            Car standard = carFactory.getCar("standard");
            carFleet.add(standard);
            inventory.addCar(standard);
            inventory.rentCar(standard);

            Car suv = carFactory.getCar("suv");
            carFleet.add(suv);
            inventory.addCar(suv);

            Car luxury = carFactory.getCar("luxury");
            carFleet.add(luxury);
            inventory.addCar(luxury);

            Car minivan = carFactory.getCar("minivan");
            carFleet.add(minivan);
            inventory.addCar(minivan);
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
//        }*/
        inventory.printAllCars();
        inventory.printCarsRented();
        //inventory.printCarsInventory();
//        }

        List<Car> rentedCars = new ArrayList<Car>();

        for (int day = 0; day < 36; day++){

            System.out.println("Day: " + day);

            for (int i = 0; i < rentedCars.size(); i++){ // Check if any rented cars are 0, and should be returned
                Car rentedCar =rentedCars.get(i);

                if (rentedCar.getDaysLeft() == 0){
                    rentedCars.remove(rentedCar);
                    carFleet.add(rentedCar);
                }
            }


//            Choose a random customer and car to rent
            Random rand = new Random();
            Customer randomCustomer = customerList.get(rand.nextInt(customerList.size()));
            if (!(randomCustomer instanceof BusinessCustomer) || carFleet.size() > 2){
                for (int rentNum = 0; rentNum < randomCustomer.getRentals(); rentNum++) { // Loop for all cars that customer is renting
                    if (carFleet.size() > 0) { // Make sure that there is at least 1 car


                        Car randomCar = carFleet.get(rand.nextInt(carFleet.size()));
                        randomCar.setDaysLeft(randomCustomer.getDaysPerRental());
                        rentedCars.add(randomCar);
                        carFleet.remove(randomCar);
                        RentalRecord r = new RentalRecord(randomCustomer, randomCar);
                        r.printRecord();
                        System.out.println('\n');


                    }
                }
            }


            for (int i = 0; i < rentedCars.size(); i++){
                rentedCars.get(i).decreaseDaysLeft(); // At the end of the day, decrease the number of days left for each rental car
            }
        }
    }
}

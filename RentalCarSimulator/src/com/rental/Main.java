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

        RentCar rent = new RentCar();

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

//The inventory has 3 lists, 1) all the cars: allcars, 2) cars currently in storage:
//carInInventory, 3) cars that are currently rented out: carRented. There are functions
//that will keep track of them used in the RentCar function below. You can see everything
//it does in CarInventory.java. Also we don't need the carFleet anymore. We might have to
//delete one of the cars to get it to be 24 cars instead of 25.



        //remove the last element to meet assignment requirements of 24 total cars in rental catalog
        //specifically, this leaves 5 of each category of car EXCEPT Minivan which will have 4 total cars in the fleet
        carFleet.remove(carFleet.size() - 1);

        //Instantiate all of the customers and add them to a customer list
        Customer Becca = new BusinessCustomer("Becca");
        customerList.add(Becca);
//        rent.Rent(Becca,inventory);
        Customer Bryan = new BusinessCustomer("Bryan");
        customerList.add(Bryan);
//        rent.Rent(Bryan,inventory);
        Customer Bridget = new BusinessCustomer("Bridget");
        customerList.add(Bridget);
//        rent.Rent(Bridget,inventory);
        Customer Brandon = new BusinessCustomer("Brandon");
        customerList.add(Brandon);
//        rent.Rent(Brandon,inventory);

        Customer Carrie = new CasualCustomer("Carrie");
        customerList.add(Carrie);
//        rent.Rent(Carrie,inventory);
        Customer Carlos = new CasualCustomer("Carlos");
        customerList.add(Carlos);
//        rent.Rent(Carlos,inventory);
        Customer Christine = new CasualCustomer("Christine");
        customerList.add(Christine);
//        rent.Rent(Christine,inventory);
        Customer Cory = new CasualCustomer("Cory");
        customerList.add(Cory);
//        rent.Rent(Cory,inventory);

        Customer Ryan = new RegularCustomer("Ryan");
        customerList.add(Ryan);
//        rent.Rent(Ryan,inventory);
        Customer Rachel = new RegularCustomer("Rachel");
        customerList.add(Rachel);
//        rent.Rent(Rachel,inventory);
        Customer Richard = new RegularCustomer("Richard");
        customerList.add(Richard);
//        rent.Rent(Richard,inventory);
        Customer Ruth = new RegularCustomer("Ruth");
        customerList.add(Ruth);
//        rent.Rent(Ruth,inventory);


//To do the simulation you can use rent.Rent(customer, inventory) on random customers
//in the customerList. The function removes a car from inventory and puts it in a list
//of rented cars. It also creates a RentalRecord and stores all the records in a list
//called rent.records. You can see what it does in RentCar file. You can also call
//rent.ReturnCar(customer, inventory) and it will put the car back into inventory and remove
//it from the rented list. If there aren't enough cars to rent per person, it will print a
//message saying there aren't enough cars and skip it.

        for(int day = 0; day < 36; day++){

            Random rand = new Random();

//            System.out.println("Day: " + day);

            int numCusomers = rand.nextInt( 5); // Choose a random number of customers to rent today

            for(int cust = 0; cust < numCusomers; cust++){

                Random rand2 = new Random();

                Customer randomCustomer = customerList.get(rand2.nextInt(customerList.size()));

//                System.out.println("Customer " + randomCustomer.getName() + "is renting");

                rent.Rent(randomCustomer, inventory);
            }


            // Used an observer pattern to notify all rented cars that their "days left" goes down 1
            rent.dayChange(inventory);
        }


//        inventory.printCarsRented();

        rent.printRecords();

        System.out.println("Total Sales: $"  + rent.getTotalSales());

//rent.printRecords prints out all of the records of the rentals. It keeps track of the
//customer, car details, how long its rented out for, the rate, the base price, the total
//price when including optional features (GPS, etc.) and whether it was returned or not.
//When you call rent.ReturnCar it goes back to the record and changes returned to true
//and sets the rented boolean to false. The costs are calculated in the files
//with names concerning cost. The additional cost calculations can be found in
//newTotalCost.java file

        //check info about customers w simple print statement
//        for(Customer c:customerList){
//            c.getName();
//            c.getRentals();
//            c.getCustomerType();
//            c.getDaysPerRental();
//
//        }
/*
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
        //inventory.printAllCars();
        //inventory.printCarsRented();
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
            */

    }
}

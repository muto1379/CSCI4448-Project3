package com.rental;

public class CasualCustomer implements Customer {
    private String name;
    private String customerType;
    private int rentals;

    public CasualCustomer(String name) {
        this.name=name;
        customerType="Casual";
        rentals = 1;
    }

    @Override
    public int getRentals(){
        System.out.println(rentals);
        return rentals;
    }

    @Override
    public String getCustomerType() {
        System.out.println(customerType);
        return customerType;
    }


    @Override
    public String getName() {
        System.out.println(name);
        return name;
    }
}

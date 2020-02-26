package com.rental;

public class BusinessCustomer implements Customer {
    private String name;
    private String customerType;
    private int rentals;

    public BusinessCustomer(String name) {
        this.name = name;
        customerType="Business";
        rentals = 3;
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

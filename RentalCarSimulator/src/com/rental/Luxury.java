package com.rental;

public class Luxury implements Car {

    private int rate;
    private String plate;
    private String type;
    private boolean rented;
    private static int ID = 1;
    public void setRented(boolean rented) {
        this.rented = rented;
    }
    public void decreaseDaysLeft() {
        this.rentDaysLeft--;
    }
    private int rentDaysLeft;

    public Luxury(){
        rate=60;
        plate=setPlate();
        type = "Luxury";
        rented = false;
        rentDaysLeft = 0;

        ++ID;
    }

    @Override
    public boolean isRented(){
//        System.out.println(rented);
        return rented;
    }

    @Override
    public int getDaysLeft(){
//        System.out.println(plate);
        return rentDaysLeft;
    }

    @Override
    public String getPlate(){
//        System.out.println(plate);
        return plate;
    }

    @Override
    public String getType(){
//        System.out.println(type);
        return type;
    }

    @Override
    public int getRate(){
//        System.out.println("$"+rate + " per day");
        return rate;
    }

    public String setPlate(){
        plate="L"+Integer.toString(ID);
        return plate;
    }
    public void setDaysLeft(int days){
//        System.out.println("$"+rate + " per day");
        this.rentDaysLeft = days;
    }

}

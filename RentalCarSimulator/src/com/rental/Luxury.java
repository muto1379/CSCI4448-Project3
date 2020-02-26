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

    public Luxury(){
        rate=60;
        plate=setPlate();
        type = "Luxury";
        rented = false;

        ++ID;
    }

    @Override
    public boolean isRented(){
//        System.out.println(rented);
        return rented;
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
}

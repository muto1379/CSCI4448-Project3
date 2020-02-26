package com.rental;

public class Economy implements Car{

    private int rate;
    private String plate;
    private String type;

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    private boolean rented;
    private static int ID = 1;

    public Economy(){
        rate=20;
        plate=setPlate();
        type="Economy";
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
        plate="E"+Integer.toString(ID);
        return plate;
    }
}

package com.rental;

public class Standard implements Car {

    private int rate;
    private String plate;
    private String type;
    private static int ID = 1;


    public Standard(){
        rate = 30;
        plate=setPlate();
        type = "Standard";

        ++ID;
    }

    @Override
    public String getPlate(){
        System.out.println(plate);
        return plate;
    }

    @Override
    public String getType(){
        System.out.println(type);
        return "Standard";
    }

    @Override
    public int getRate(){
        System.out.println("$"+rate + " per day");
        return rate;
    }

    public String setPlate(){
        plate="S"+Integer.toString(ID);
        return plate;
    }
}

package com.rental;

public class Minivan implements Car {

    private int rate;
    private String plate;
    private String type;
    private static int ID = 1;

    public Minivan(){
        rate = 40;
        plate = setPlate();
        type="Minivan";

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
        return type;
    }

    @Override
    public int getRate(){
        System.out.println("$"+rate + " per day");
        return rate;
    }

    public String setPlate(){
        plate="M"+Integer.toString(ID);
        return plate;
    }
}

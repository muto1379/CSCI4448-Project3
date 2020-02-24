package com.rental;

public class Economy implements Car{

    private int rate;
    private String plate;
    private String type;
    private static int ID = 1;

    public Economy(){
        rate=20;
        plate=setPlate();
        type="Economy";

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
        plate="E"+Integer.toString(ID);
        return plate;
    }
}

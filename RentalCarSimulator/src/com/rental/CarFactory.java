package com.rental;

public class CarFactory {

    public Car getCar(String carType){
        if(carType==null)
            return null;
        if(carType.equalsIgnoreCase("ECONOMY"))
            return new Economy();
        else if(carType.equalsIgnoreCase("STANDARD"))
            return new Standard();
        else if(carType.equalsIgnoreCase("LUXURY"))
            return new Luxury();
        else if(carType.equalsIgnoreCase("SUV"))
            return new SUV();
        else if(carType.equalsIgnoreCase("MINIVAN"))
            return new Minivan();

        return null;
    }

}

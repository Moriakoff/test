package model;

import java.util.Arrays;
import java.util.Random;

public class Car implements Comparable<Car> {
    private String model;
    private int year;
    private double engine;
    private boolean ac;

    private static Random gen = new Random();

    public Car() {
    }

    public Car(String model, int year, double engine, boolean ac) {
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.ac = ac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    @Override
    public String toString() {
        return  "model='" + model + '\'' +
                ", year=" + year +
                ", engine=" + String.format("%.2f",engine) +
                ", ac=" + ac;
    }

    public static Car getRandomCar(){
        String n = "Name#_"+ gen.nextInt(100);
        int y = 1900 + gen.nextInt(119);
        double e = (1+gen.nextInt(4)) * gen.nextDouble();
        boolean a =gen.nextBoolean();

        return new Car(n,y,e,a);
    }

    @Override
    public int compareTo(Car o) {
        return Double.compare(getEngine(),o.getEngine());
    }

    public static Car[] findCarsInEngineRange(Car[] garage,double engMin, double engMax){
        int cap = 0;
        Car[] newGarage = garage;
        for (int i = 0; i < garage.length; i++) {
            if(garage[i].getEngine() >= engMin && garage[i].getEngine() <=engMax) {
                newGarage[cap] = garage[i];
                cap ++;
            }
        }
        newGarage = Arrays.copyOf(newGarage, cap);
        return newGarage;
    }
}

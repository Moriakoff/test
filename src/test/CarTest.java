package test;

import model.Car;
import model.EngineComparator;
import model.Finder;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private Car[] garage;
    private Car[] newGarage;
    private Finder<Car> finderCar = new Finder<>();
    private Finder<Integer> finderInt = new Finder<>();
    private Comparator<Car> engineComparator = new EngineComparator();
    private Comparator<Integer> intComp = Comparator.naturalOrder();
    private static Random gen = new Random();
    private Integer[] num;


    @org.junit.Before
    public void setUp() {
        garage = new Car[5];
        garage[0] = new Car("Volvo#1",1976,1.5,true);
        garage[1] = new Car("Volvo#2",1978,1.8,true);
        garage[2] = new Car("Volvo#3",1981,1.6,true);
        garage[3] = new Car("Volvo#4",1995,0.5,true);
        garage[4] = new Car("Volvo#5",2015,1.4,true);
        System.out.println();

        num = new Integer[17];
        for (int i = 0; i < num.length; i++) {
            num[i] = gen.nextInt(6);
        }

        Arrays.sort(num);
        Arrays.sort(garage,engineComparator);
     }

    @org.junit.Test
    public void findCarsInEngineRange() {
        newGarage = Car.findCarsInEngineRange(garage, 1., 1.6);
        assertEquals(3,newGarage.length);
        System.out.println(Arrays.toString(newGarage));
    }

    @Test
    public void findInRange(){
        System.out.println(Arrays.toString(num));
        Integer[] res = finderInt.findInRange(num, 2, 6, intComp);
        System.out.println(Arrays.toString(res));
    }

}
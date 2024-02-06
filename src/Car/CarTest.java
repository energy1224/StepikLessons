package Car;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {

        Garage garage = new Garage(4);

        Car car01 = new Car("iveko", 7.9);
        Car car02 = new Car("bmw", 4.5);
        Car car03= new Car("VOLGA", 2.5);
        Car car04 = new Car("oka", 1.2);

        try {
            garage.putCar(car01,1);
            garage.putCar(car02,2);
            garage.putCar(car03,3);
            garage.putCar(car04,4);
            garage.getCar(2);
            System.out.println();
            for (Car car : garage) {
                System.out.println(car);
            }

            garage.getCar(3);
            System.out.println();
            for (Car car : garage) {
                System.out.println(car);
            }
            System.out.println();

            System.out.println(garage.getFreeBoxnumber());

        } catch (ErrorBoxException e) {
            System.out.println("wrong data");
        }





    }
}

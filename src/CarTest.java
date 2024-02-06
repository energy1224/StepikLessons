import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
public class CarTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String index = scan.nextLine();
        int ind = Integer.parseInt(index);
        Car[] cars = new Car[ind];
        if (ind <= 0) {
            System.out.println("ERROR");
        } else {
            for (int i = 0; i < cars.length; i++) {
                String car = scan.nextLine();
                String[] dataCar = car.split(" ");
                int type= Integer.parseInt(dataCar[0]);
                if (type == 1) {
                    cars[i] = new Car();
                } else {
                    cars[i] = new Truck();
                }
                cars[i].setModel(dataCar[1]);
                cars[i].setOwner(dataCar[2]);
                cars[i].setEngine(Double.parseDouble(dataCar[3]));
                cars[i].setYear(Integer.parseInt(dataCar[4]));
                if (dataCar.length == 6) {
                    ((Truck) cars[i]).setCapacity(Double.parseDouble(dataCar[5]));
                }
            }
        }
        double weight = Double.parseDouble(scan.nextLine());
        for (Car car : cars) {
            System.out.println(car);

        }
        System.out.println();


        int number = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] instanceof Truck) {
                Truck truck = (Truck) cars[i];
                if (truck.ifCanCarry(weight) && truck.getLife() < 6) {
                    number++;
                    System.out.println(truck);
                }
            }
        }
             if(number==0) {
            System.out.println("NO");
        }


    }
}

class Car {

    private String model;
    private String owner;

    private double engine;
    private int year;

    private static int currentYear;

    static {
        Calendar cal = Calendar.getInstance(); //не забыть импортировать класс java.util.Calendar!
        currentYear = cal.get(Calendar.YEAR);
    }

    int getLife() {
        return currentYear - year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                ", engine=" + engine +
                ", year=" + year +
                '}';
    }

    public Car() {
    }


    public Car(String model, String owner, double engine, int year) {
        this.model = model;
        this.owner = owner;
        this.engine = engine;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

class Truck extends Car {

    private double capacity;

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public Truck() {
    }

    public Truck(String model, String owner, double engine, int year, double capacity) {
        super(model, owner, engine, year);
        this.capacity = capacity;
    }

    boolean ifCanCarry(double weight) {
        return capacity > weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + super.getModel()+ '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", engine=" + super.getEngine() +
                ", year=" + super.getYear() +
                ", capacity=" + capacity +
                '}';
    }
}

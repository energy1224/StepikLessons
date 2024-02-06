package Car;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Garage implements Iterable<Car> {
    private Car[] cars;

    public Garage(int boxes) {
        this.cars = new Car[boxes];
    }

    public Car[] getCars() {
        return cars;
    }

    void putCar(Car unit, int i) throws ErrorBoxException {
        if (i >= cars.length && i <= 0) throw new ErrorBoxException("Не верный номер бокса");
        if (cars[i - 1] != null) throw new ErrorBoxException("Не верный номер бокса");
        cars[i - 1] = unit;
    }

    Car getCar(int i) throws ErrorBoxException {
        if (i >= cars.length && i <= 0) throw new ErrorBoxException("Не верный номер бокса");
        if (cars[i - 1] == null) throw new ErrorBoxException("Не верный номер бокса");
        Car car = cars[i - 1];
        cars[i - 1] = null;
        return car;
    }

    boolean isFree(int number) throws ErrorBoxException {
        if (number >= cars.length && number <= 0) throw new ErrorBoxException("Не верный номер бокса");
        return cars[number - 1] == null;
    }

    int getFreeBoxnumber() {
        int num = 0;
        for (int i = cars.length - 1; i >= 0; i--) {
            if (cars[i] == null)
                return i + 1;

        }
        return -1;
    }





@Override
public Iterator<Car> iterator() {
    return new CarIterator();
}

private class CarIterator implements Iterator<Car> {

    private int count = cars.length - 1;


    @Override
    public boolean hasNext() {
        return count >= 0;
    }

    @Override
    public Car next() {
        if (!hasNext()) throw new NoSuchElementException();
        return cars[count--];
    }
}
}

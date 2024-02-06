package Car;

public class Car {

    private String model;

    private double engine;


    @Override
    public String toString() {
        return  model + ";" + engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public Car(String model, double engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car() {
    }
}

package Exercise_1;

class Vehicle {
    private String brand;
    private int year;

    public Vehicle() {
        this.brand = "Unknown";
        this.year = 0;
    }

    public Vehicle(String b, int y) {
        this.brand = b;
        this.year = y;
    }

    public String getBrand() { return brand; }
    public int getYear() {return year;}

    public void setBrand(String b) {brand = b;}
    public void setYear(int y) {year = y;}

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

class Car extends Vehicle{
    private String model;

    public Car() {
        super();
        this.model = "Unknown";
    }

    public Car(String brand, int year, String model) {
        super(brand, year);
        this.model = model;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand() + ", Model: " + model + ", Year: " + getYear());
    }
}

class Bike extends Vehicle {
    private int engineCapacity;

    public Bike() {
        super();
        this.engineCapacity = 0;
    }

    public Bike(String brand, int year, int engineCapacity) {
        super(brand, year);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand() + ", Engine: " + engineCapacity + "cc, Year: " + getYear());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Creating car1 (Default) ---");
        Car car1 = new Car();
        car1.displayInfo();

        System.out.println("\n--- Creating car2 (Parameterized) ---");
        Car car2 = new Car("Toyota", 2023, "Camry");
        car2.displayInfo();

        System.out.println("\n--- Creating bike1 (Default) ---");
        Bike bike1 = new Bike();
        bike1.displayInfo();

        System.out.println("\n--- Creating bike2 (Parameterized) ---");
        Bike bike2 = new Bike("Yamaha", 2020, 150);
        bike2.displayInfo();
    }
}
class Vehicle {
    String name;

    public Vehicle(String name) { this.name = name; }

    public void start() {
        System.out.println("Starting vehicle " + this.name + ".");
    }

    public void drive() {
        System.out.println("Driving vehicle " + this.name + ".");
    }

    public void stop() {
        System.out.println("Stopping vehicle " + this.name + ".");
    }
}


class ElectricVehicle extends Vehicle {
    double charge = 0.0; // percentage of battery charged, between 0 and 100

    public ElectricVehicle(String name) {
        super(name);
        this.charge = 100; // new instances are fully charged
    }
    // overriding
    public void start() {
        System.out.println("Starting electric vehicle " + name + ".");
    }

    public void drive() {
        System.out.println("Driving electric vehicle " + name + ".");
    }

    public void stop() {
        System.out.println("Stopping electric vehicle " + name + ".");
    }

    public double getCharge() { return this.charge; }

    public static void main(String... args) {
        Vehicle v1 = new Vehicle("Truck");
        ElectricVehicle v2 = new ElectricVehicle("Tesla");
        //We are assigning a Child object to a variable of type Parent.
        Vehicle v3 = new ElectricVehicle("Leaf");
        v1.start();
        v2.start();
        v3.start();
        v2.getCharge();
       // v3.getCharge();
    }
}

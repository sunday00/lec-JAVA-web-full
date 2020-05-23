package lec.spring.di;

public class Car {
    private Engine v8;

    public Car() {
        System.out.println("Car is ready");
    }

    public void setEngine (Engine engine) {
        this.v8 = engine;
    }

    public void run() {
        System.out.println("Engine is now running");
        v8.exec();
    }

//    public static void main(String[] args) {
//        Engine e = new Engine();
//        Car c = new Car();
//        c.setEngine(e);
//        c.run();
//    }

}

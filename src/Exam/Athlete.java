package Exam;

public class Athlete extends HomoSapien {
    public Athlete(double weight, double height, int age) {
        super(weight, height, age);
    }

    public void runningFaster() {
        System.out.println("Athlete is running faster...");
    }

    public void jumpingHigher() {
        System.out.println("Athlete is jumping higher...");
    }
}

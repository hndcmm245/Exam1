package Exam;

public class HomoSapien extends Animal {
    protected boolean twoFeet = true;
    protected boolean twoHands = true;

    public HomoSapien(double weight, double height, int age) {
        super(weight, height, age);
    }

    public void speak() {
        System.out.println("Homo Sapien is speaking...");
    }

    public void run() {
        System.out.println("Homo Sapien is running...");
    }
}

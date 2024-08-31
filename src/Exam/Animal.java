package Exam;

public class Animal {
    protected double weight;
    protected double height;
    protected int age;

    public Animal(double weight, double height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public void speak() {
        System.out.println("Animal is making a sound...");
    }

    public void run() {
        System.out.println("Animal is running...");
    }

    // Getters and Setters
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package org.example.customarraylist;

public class Car {
    private String brand;
    private int number;

    public Car(String brand, int number) {
        this.brand = brand;
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, number: %d", brand, number);
    }
}

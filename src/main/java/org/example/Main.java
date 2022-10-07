package org.example;

public class Main {
    public static void main(String[] args) {
        CarListArray carList = new CarListArray();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
        System.out.println(carList.size());

        carList.removeAt(5);
        System.out.println(carList.size());
        carList.remove(new Car("Brand10", 10));
        System.out.println(carList.size());
        System.out.println(carList.get(20));
        System.out.println(carList.size());


        carList.add(new Car("BMW", 245), 1);
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i));
        }
        System.out.println(carList.size());
    }
}

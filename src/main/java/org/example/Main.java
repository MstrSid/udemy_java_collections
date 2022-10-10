package org.example;

import org.example.customarraylist.CarListArray;
import org.example.customhashset.CarHashSet;
import org.example.customlinkedlist.CarLinkedList;
import org.example.interfaces.CarCollection;
import org.example.interfaces.CarList;
import org.example.interfaces.CarSet;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        for (int n : numbers) {
            System.out.println(n);
        }
        System.out.println();
        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }
        });
        for (int i = 0; i < 100; i++) {
            cars.add(new Car("Brand" + i, i));
        }
        cars.add(new Car("Mazda1", 111));
        cars.add(new Car("Mazda2", 111));

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

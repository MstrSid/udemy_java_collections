package org.example;

import org.example.customarraylist.CarListArray;
import org.example.customhashset.CarHashSet;
import org.example.customlinkedlist.CarLinkedList;
import org.example.interfaces.CarSet;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 1);
        Car car2 = new Car("BMW", 1);
        Car car3 = new Car("Mazda", 11);
        Car car4 = new Car("Mazda", 12);

        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());

        System.out.println(car1 == car2);

        CarHashSet carHashSet = new CarHashSet();
        CarListArray carListArray = new CarListArray();
        CarLinkedList carLinkedList = new CarLinkedList();
        carHashSet.add(car1);
        carHashSet.add(car2);
        carHashSet.add(car3);
        System.out.println(carHashSet.contains(car3));
        System.out.println();
        carListArray.add(car1);
        carListArray.add(car2);
        carListArray.add(car3);
        System.out.println(carListArray.contains(car3));
        System.out.println();
        carLinkedList.add(car1);
        carLinkedList.add(car2);
        carLinkedList.add(car3);
        System.out.println(carLinkedList.contains(car3));
    }
}

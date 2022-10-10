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
    HashMap<CarOwner, Car> cars = new HashMap<>();
    cars.put(new CarOwner(1, "Mike", "Stevens"),
        new Car("Mazda", 323));
    cars.put(new CarOwner(2, "Bob", "Dow"),
        new Car("Mazda", 626));
    cars.put(new CarOwner(3, "Ann", "Lynch"),
        new Car("Mazda", 121));

    for (CarOwner key : cars.keySet()) {
      System.out.println(key + ": " + cars.get(key));
    }
  }

  private static void showNumbersWithComparator() {
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
  }

  private static void showCarsWithComparator() {
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

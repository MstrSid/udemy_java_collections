package org.example.interfaces;

import java.util.List;
import java.util.Set;
import org.example.Car;
import org.example.CarOwner;

public interface CarMap {

  void put(CarOwner key, Car value);

  Car get(CarOwner key);

  Set<CarOwner> keySet();

  List<Car> values();

  boolean remove(CarOwner key);

  int size();

  void clear();
}

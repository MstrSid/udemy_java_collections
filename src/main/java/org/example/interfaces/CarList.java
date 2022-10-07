package org.example.interfaces;

import org.example.Car;

public interface CarList {
    Car get(int index);

    void add(Car car);

    void add(Car car, int index);

    boolean remove(Car car);

    boolean removeAt(int index);

    int size();

    void clear();
}

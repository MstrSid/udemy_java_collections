package org.example.customarraylist;

import org.example.Car;
import org.example.interfaces.CarList;

import java.util.Arrays;

public class CarListArray implements CarList {

    private Car[] carArray = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return carArray[index];
    }

    @Override
    public boolean add(Car car) {
        checkSizeAndIncreaseArray();
        carArray[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean add(Car car, int index) {
        checkSizeAndIncreaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(carArray, index, carArray, index + 1, size - index);
        carArray[index] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (car.toString().equals(carArray[i].toString())) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        if (index > size || index < 0 || carArray[index] == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (size - 1 - index >= 0)
                System.arraycopy(carArray, index + 1, carArray, index, size - 1 - index);
            carArray[size - 1] = null;
            size--;
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Car car) {
        for (int i = 0; i < size; i++) {
            if (carArray[i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        carArray = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkSizeAndIncreaseArray() {
        if (size >= carArray.length) {
            carArray = Arrays.copyOf(carArray, carArray.length * 2);
        }
    }
}

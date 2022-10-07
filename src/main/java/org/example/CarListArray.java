package org.example;

public class CarListArray implements CarList {

    private Car[] carArray = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        if (index > size || index < 0 || carArray[index] == null) {
            throw new IndexOutOfBoundsException();
        } else return carArray[index];
    }

    @Override
    public void add(Car car) {
        if (size == carArray.length) {
            Car[] tempArray = new Car[size * 2];
            for (int i = 0; i < size; i++) {
                tempArray[i] = carArray[i];
            }
            carArray = tempArray;
        }
        carArray[size] = car;
        size++;
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
            for (int i = index; i < size - 1; i++) {
                carArray[i] = carArray[i + 1];
            }
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
    public void clear() {
        carArray = new Car[10];
        size = 0;
    }
}

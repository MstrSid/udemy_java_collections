package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarListArray();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsTHenSizeMusBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Mazda", 1255);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistedElementRemovedThenReturnFalse() {
        Car car = new Car("Mazda", 1255);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test()
    public void whenIndexOfBoundsThenThrownException() {
        assertThrows(Exception.class, () -> {
            carList.get(100);
        });

    }

    @Test
    public void getReturnRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
        assertEquals(0, car.getNumber());
    }
}
package org.example;

import org.example.Car;
import org.example.customhashset.CarHashSet;
import org.example.interfaces.CarSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenAddedEqualsElementsThenAddedOnlyOne() {
        Car car = new Car("BMW", 1020);
        carSet.add(car);
        carSet.add(car);
        carSet.add(car);
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenRemoveElementThenSizeMustBeDecreased() {
        Car car = new Car("BMW", 1020);
        carSet.add(car);
        assertEquals(101, carSet.size());
        assertTrue(carSet.remove(car));
        assertEquals(100, carSet.size());
        assertFalse(carSet.remove(car));
        assertEquals(100, carSet.size());
    }

    @Test
    public void whenListIsClearedThenSizeIs0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }
}
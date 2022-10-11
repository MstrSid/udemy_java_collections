package org.example;

import org.example.customlinkedlist.CustomLinkedList;
import org.example.interfaces.CustomList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {

  private CustomList<Car> customList;

  @BeforeEach
  void setUp() {
    customList = new CustomLinkedList<>();
    for (int i = 0; i < 100; i++) {
      customList.add(new Car("Brand" + i, i));
    }
  }

  @Test
  public void whenAdded100ElementsTHenSizeMusBe100() {
    assertEquals(100, customList.size());
  }

  @Test
  public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
    assertTrue(customList.removeAt(5));
    assertEquals(99, customList.size());
  }

  @Test
  public void whenElementRemovedThenSizeMustBeDecreased() {
    Car car = new Car("Mazda", 1255);
    customList.add(car);
    assertEquals(101, customList.size());
    assertTrue(customList.remove(car));
    assertEquals(100, customList.size());
  }

  @Test
  public void whenNonExistedElementRemovedThenReturnFalse() {
    Car car = new Car("Mazda", 1255);
    assertFalse(customList.remove(car));
    assertEquals(100, customList.size());
  }

  @Test
  public void whenListClearedThenSizeMustBe0() {
    customList.clear();
    assertEquals(0, customList.size());
  }

  @Test()
  public void whenIndexOfBoundsThenThrownException() {
    assertThrows(Exception.class, () -> {
      customList.get(100);
    });

  }

  @Test
  public void getReturnRightValue() {
    Car car = customList.get(0);
    assertEquals("Brand0", car.getBrand());
    assertEquals(0, car.getNumber());
  }

  @Test
  public void insertIntoMiddle() {
    Car car = new Car("BMW", 254);
    customList.add(car, 50);
    Car carFromList = customList.get(50);
    assertEquals("BMW", carFromList.getBrand());
    assertEquals(254, carFromList.getNumber());
  }

  @Test
  public void insertIntoFirstPosition() {
    Car car = new Car("BMW", 254);
    customList.add(car, 0);
    Car carFromList = customList.get(0);
    assertEquals("BMW", carFromList.getBrand());
    assertEquals(254, carFromList.getNumber());
  }

  @Test
  public void insertIntoLastPosition() {
    Car car = new Car("BMW", 254);
    customList.add(car, 100);
    Car carFromList = customList.get(100);
    assertEquals("BMW", carFromList.getBrand());
    assertEquals(254, carFromList.getNumber());
  }
}
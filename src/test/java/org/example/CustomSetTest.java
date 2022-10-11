package org.example;

import org.example.customhashset.CustomHashSet;
import org.example.interfaces.CustomSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSetTest {

  private CustomSet<Car> customSet;

  @BeforeEach
  void setUp() {
    customSet = new CustomHashSet<>();
    for (int i = 0; i < 100; i++) {
      customSet.add(new Car("Brand" + i, i));
    }
  }

  @Test
  public void whenAdded100ElementsThenSizeMustBe100() {
    assertEquals(100, customSet.size());
  }

  @Test
  public void whenAddedEqualsElementsThenAddedOnlyOne() {
    Car car = new Car("BMW", 1020);
    customSet.add(car);
    customSet.add(car);
    customSet.add(car);
    assertEquals(101, customSet.size());
  }

  @Test
  public void whenRemoveElementThenSizeMustBeDecreased() {
    Car car = new Car("BMW", 1020);
    customSet.add(car);
    assertEquals(101, customSet.size());
    assertTrue(customSet.remove(car));
    assertEquals(100, customSet.size());
    assertFalse(customSet.remove(car));
    assertEquals(100, customSet.size());
  }

  @Test
  public void whenListIsClearedThenSizeIs0() {
    customSet.clear();
    assertEquals(0, customSet.size());
  }
}
package org.example;

import org.example.customarraylist.CarListArray;
import org.example.customhashset.CarHashSet;
import org.example.customlinkedlist.CarLinkedList;
import org.example.interfaces.CarCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {

  private CarCollection carCollection;
  private CarCollection carCollection2;

  private CarCollection carCollection3;

  @BeforeEach
  void setUp() throws Exception {
    carCollection = new CarHashSet();
    for (int i = 0; i < 100; i++) {
      carCollection.add(new Car("Brand" + i, i));
    }

    carCollection2 = new CarLinkedList();
    for (int i = 0; i < 100; i++) {
      carCollection2.add(new Car("Brand" + i, i));
    }

    carCollection3 = new CarListArray();
    for (int i = 0; i < 100; i++) {
      carCollection3.add(new Car("Brand" + i, i));
    }
  }

  @Test
  public void contains() {
    assertTrue(carCollection.contains(new Car("Brand30", 30)));
    assertFalse(carCollection.contains(new Car("Brand500", 500)));
    assertTrue(carCollection2.contains(new Car("Brand30", 30)));
    assertFalse(carCollection2.contains(new Car("Brand500", 500)));
    assertTrue(carCollection3.contains(new Car("Brand30", 30)));
    assertFalse(carCollection3.contains(new Car("Brand500", 500)));
  }

  @Test
  public void testForEach() {
    int index = 0;
    int index2 = 0;
    int index3 = 0;
    for (Car car : carCollection) {
      index++;
    }
    for (Car car : carCollection2) {
      index2++;
    }
    for (Car car : carCollection3) {
      index3++;
    }
    assertEquals(100, index);
    assertEquals(100, index2);
    assertEquals(100, index3);
  }
}
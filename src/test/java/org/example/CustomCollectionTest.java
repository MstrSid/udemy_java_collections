package org.example;

import org.example.customarraylist.CustomListArray;
import org.example.customhashset.CustomHashSet;
import org.example.customlinkedlist.CustomLinkedList;
import org.example.interfaces.CustomCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomCollectionTest {

  private CustomCollection<Car> customCollection;
  private CustomCollection<Car> customCollection2;

  private CustomCollection<Car> customCollection3;

  @BeforeEach
  void setUp() throws Exception {
    customCollection = new CustomHashSet<>();
    for (int i = 0; i < 100; i++) {
      customCollection.add(new Car("Brand" + i, i));
    }

    customCollection2 = new CustomLinkedList<>();
    for (int i = 0; i < 100; i++) {
      customCollection2.add(new Car("Brand" + i, i));
    }

    customCollection3 = new CustomListArray<>();
    for (int i = 0; i < 100; i++) {
      customCollection3.add(new Car("Brand" + i, i));
    }
  }

  @Test
  public void contains() {
    assertTrue(customCollection.contains(new Car("Brand30", 30)));
    assertFalse(customCollection.contains(new Car("Brand500", 500)));
    assertTrue(customCollection2.contains(new Car("Brand30", 30)));
    assertFalse(customCollection2.contains(new Car("Brand500", 500)));
    assertTrue(customCollection3.contains(new Car("Brand30", 30)));
    assertFalse(customCollection3.contains(new Car("Brand500", 500)));
  }

  @Test
  public void testForEach() {
    int index = 0;
    int index2 = 0;
    int index3 = 0;
    for (Car car : customCollection) {
      index++;
    }
    for (Car car : customCollection2) {
      index2++;
    }
    for (Car car : customCollection3) {
      index3++;
    }
    assertEquals(100, index);
    assertEquals(100, index2);
    assertEquals(100, index3);
  }
}
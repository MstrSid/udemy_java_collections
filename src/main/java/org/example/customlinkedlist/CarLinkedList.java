package org.example.customlinkedlist;

import org.example.Car;
import org.example.interfaces.CarList;

import java.util.Iterator;

public class CarLinkedList implements CarList {

  private Node first;
  private Node last;
  private int size = 0;

  @Override
  public Car get(int index) {
    return getNode(index).value;
  }

  @Override
  public boolean add(Car car) {
    if (size == 0) {
      Node node = new Node(null, car, null);
      first = node;
      last = node;
    } else {
      Node secondLast = last;
      last = new Node(secondLast, car, null);
      secondLast.next = last;
    }
    size++;
    return true;
  }

  @Override
  public boolean add(Car car, int index) {
    if (index == size) {
      return add(car);
    }
    Node nodeNext = getNode(index);
    Node nodePrevious = nodeNext.previous;
    Node newNode = new Node(nodePrevious, car, nodeNext);
    nodeNext.previous = newNode;
    if (nodePrevious != null) {
      nodePrevious.next = newNode;
    } else {
      first = newNode;
    }
    size++;
    return true;
  }

  @Override
  public boolean remove(Car car) {
    Node node = first;
    for (int i = 0; i < size; i++) {
      if (node.value.toString().equals(car.toString())) {
        return removeAt(i);
      }
      node = node.next;
    }
    return false;
  }

  @Override
  public boolean removeAt(int index) {
    Node node = getNode(index);
    Node nodeNext = node.next;
    Node nodePrevious = node.previous;
    if (nodeNext != null) {
      nodeNext.previous = nodePrevious;
    } else {
      last = nodePrevious;
    }

    if (nodePrevious != null) {
      nodePrevious.next = nodeNext;
    } else {
      first = nodeNext;
    }
    size--;
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(Car car) {
    for (int i = 0; i < size; i++) {
      if (getNode(i).value.equals(car)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void clear() {
    first = null;
    last = null;
    size = 0;
  }

  private Node getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node node = first;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  @Override
  public Iterator<Car> iterator() {
    return new Iterator<Car>() {
      private Node node = first;

      @Override
      public boolean hasNext() {
        return node != null;
      }

      @Override
      public Car next() {
        Car car = node.value;
        node = node.next;
        return car;
      }
    };
  }

  private static class Node {

    private Node previous;
    private final Car value;
    private Node next;

    public Node(Node previous, Car value, Node next) {
      this.previous = previous;
      this.value = value;
      this.next = next;
    }
  }
}

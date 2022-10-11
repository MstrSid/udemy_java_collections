package org.example.customlinkedlist;

import java.util.Iterator;
import org.example.interfaces.CustomList;

public class CustomLinkedList<T> implements CustomList<T> {

  private Node first;
  private Node last;
  private int size = 0;

  @Override
  public T get(int index) {
    return getNode(index).value;
  }

  @Override
  public boolean add(T elem) {
    if (size == 0) {
      Node node = new Node(null, elem, null);
      first = node;
      last = node;
    } else {
      Node secondLast = last;
      last = new Node(secondLast, elem, null);
      secondLast.next = last;
    }
    size++;
    return true;
  }

  @Override
  public boolean add(T elem, int index) {
    if (index == size) {
      return add(elem);
    }
    Node nodeNext = getNode(index);
    Node nodePrevious = nodeNext.previous;
    Node newNode = new Node(nodePrevious, elem, nodeNext);
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
  public boolean remove(T elem) {
    Node node = first;
    for (int i = 0; i < size; i++) {
      if (node.value.toString().equals(elem.toString())) {
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
  public boolean contains(T elem) {
    for (int i = 0; i < size; i++) {
      if (getNode(i).value.equals(elem)) {
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
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node node = first;

      @Override
      public boolean hasNext() {
        return node != null;
      }

      @Override
      public T next() {
        T car = node.value;
        node = node.next;
        return car;
      }
    };
  }

  private class Node {

    private Node previous;
    private final T value;
    private Node next;

    public Node(Node previous, T value, Node next) {
      this.previous = previous;
      this.value = value;
      this.next = next;
    }
  }
}

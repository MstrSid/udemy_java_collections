package org.example.interfaces;

public interface CustomList<T> extends CustomCollection<T> {

  T get(int index);

  boolean add(T car, int index);

  boolean removeAt(int index);
}

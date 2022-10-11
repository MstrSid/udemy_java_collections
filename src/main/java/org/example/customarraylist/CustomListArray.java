package org.example.customarraylist;

import java.util.Arrays;
import java.util.Iterator;
import org.example.interfaces.CustomList;

public class CustomListArray<T> implements CustomList<T> {

  private Object[] cArray = new Object[10];
  private int size = 0;

  @Override
  public T get(int index) {
    checkIndex(index);
    return (T) cArray[index];
  }

  @Override
  public boolean add(T elem) {
    checkSizeAndIncreaseArray();
    cArray[size] = elem;
    size++;
    return true;
  }

  @Override
  public boolean add(T elem, int index) {
    checkSizeAndIncreaseArray();
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    System.arraycopy(cArray, index, cArray, index + 1, size - index);
    cArray[index] = elem;
    size++;
    return true;
  }

  @Override
  public boolean remove(T elem) {
    for (int i = 0; i < size; i++) {
      if (elem.toString().equals(cArray[i].toString())) {
        return removeAt(i);
      }
    }
    return false;
  }

  @Override
  public boolean removeAt(int index) {
    if (index > size || index < 0 || cArray[index] == null) {
      throw new IndexOutOfBoundsException();
    } else {
      if (size - 1 - index >= 0) {
        System.arraycopy(cArray, index + 1, cArray, index, size - 1 - index);
      }
      cArray[size - 1] = null;
      size--;
      return true;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(T elem) {
    for (int i = 0; i < size; i++) {
      if (cArray[i].equals(elem)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void clear() {
    cArray = new Object[10];
    size = 0;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void checkSizeAndIncreaseArray() {
    if (size >= cArray.length) {
      cArray = Arrays.copyOf(cArray, cArray.length * 2);
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        return (T) cArray[index++];
      }
    };
  }
}

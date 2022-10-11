package org.example.customhashset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.example.Car;
import org.example.interfaces.CustomSet;

public class CustomHashSet<T> implements CustomSet<T> {

  private Map<T, Object> map = new HashMap<>();
  private Object object = new Object();

  @Override
  public boolean add(T elem) {
    if (map.containsKey(elem)) {
      return false;
    }
    map.put(elem, object);
    return true;
  }

  @Override
  public boolean remove(T elem) {
    Object removed = map.remove(elem);
    return removed != null;
  }

  @Override
  public int size() {
    return map.size();
  }

  @Override
  public boolean contains(T elem) {
    return map.containsKey(elem);
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  public Iterator<T> iterator() {
    return map.keySet().iterator();
  }
}

package csci2320.collections3;

import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
  private static class Node<K, V> {
    K key;
    V value;
    Node<K, V> left, right; // maybe parent
    Node(K key, V value, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      // ...
    }
  }

  private Node<K, V> root = null;

  @Override
  public V get(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  }

  @Override
  public void put(K key, V value) {
    // Not good code. Showing compare.
    int c = key.compareTo(root.key);
  }

  @Override
  public V remove(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public boolean contains(K key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'contains'");
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'size'");
  }

  @Override
  public Iterator<K> iterator() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'iterator'");
  }
  
}

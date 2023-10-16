package csci2320.collections2;

public class AVLMap<K extends Comparable<K>, V> {
  private static class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    int height;
    Node<K, V> left, right, parent;
    // Add your constructor here
  }

  private Node<K, V> root = null;

  public boolean isConsistent() {
    return isConsistent(root);
  }

  private boolean isConsistent(Node<K, V> n) {
    if (n == null) return true;
    boolean ret = true;
    if (n.left != null && n.left.key.compareTo(n.key) >= 0) {
      System.out.println("Left child key too big. " + n.key + " " + n.left.key);
      ret = false;
    }
    // Same for right
    // Validate parent pointers
    if (n.left != null && n.left.parent != n) {
      System.out.println("Left child estranged. " + n.key + " " + n.left.key);
      ret = false;
    }
    // Validate height
    // Validate balance
    boolean left = isConsistent(n.left);
    boolean right = isConsistent(n.right);
    return ret && left && right;
  }
}

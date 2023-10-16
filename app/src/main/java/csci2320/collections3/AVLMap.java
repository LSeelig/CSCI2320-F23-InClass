package csci2320.collections3;

public class AVLMap<K extends Comparable<K>, V> {
  private static class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    int height;
    Node<K, V> left, right, parent;
    // Add a constructor here
  }

  Node<K, V> root = null;

  public boolean isConsistent() {
    return isConsistent(root);
  }
 
  private boolean isConsistent(Node<K, V> n) {
    if (n == null) return true;
    boolean ret = true;
    if (n.left != null && n.left.key.compareTo(n.key) >= 0) {
      System.out.println("Left child is too big. " + n.key + " " + n.left.key);
      ret = false;
    }
    // Same code for right
    if (n.left != null && n.left.parent != n) {
      System.out.println("Left child is estranged. " + n.key + " " + n.left.key);
      ret = false;
    }
    // Same code right

    // Check height is correct
    if (n.height != Math.max(n.left.height, n.right.height) + 1) {
      System.out.println("Bad height...");
      ret = false;
    }
    // Check balance is correct
    if (Math.abs(n.left.height - n.right.height) > 1) {
      System.out.println("The balance is off ...");
    }

    boolean left = isConsistent(n.left);
    boolean right = isConsistent(n.right);
    return ret && left && right;
  }
}

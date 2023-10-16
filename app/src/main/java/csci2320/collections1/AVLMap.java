package csci2320.collections1;

import java.util.List;

public class AVLMap<K extends Comparable<K>, V> {
  private static class Node<K extends Comparable<K>, V> {
    K key;
    V value;
    int height;
    Node<K, V> left, right, parent;
  }

  private Node<K, V> root;

  public boolean isConsistent() {
    return isConsistent(root);
  }

  private boolean isConsistent(Node<K, V> n) {
    if (n == null) return true;
    boolean ret = true;
    if (n.left != null && n.left.parent != n) {
      System.out.println("Not parent of left child. " + n.key);
      ret = false;
    }
    if (n.right != null && n.right.parent != n) {
      System.out.println("Not parent of right child. " + n.key);
      ret = false;
    }
    if (n.left != null && n.left.key.compareTo(n.key) >= 0) {
      System.out.println("Left child too big. " + n.key + " " + n.left.key);
      ret = false;
    }
    // right child greater
    // Check height is consistent
    // Check chilrens height within 1

    boolean left = isConsistent(n.left);
    boolean right = isConsistent(n.right);
    return ret && left && right;
  }


  public static String foo(int a) {
    switch(a) {
      case 0:
        return "zero";
      case 1:
        return "one";
      case 2:
        return "two";
      default:
        return "big number";
    }
  }

  public static void bar() {
    var lst = List.of(1,2,3);
    //lst.stream().map(AVLMap::foo)
  }

  private int height(Node<K, V> n) {
    if (n==null) return 0;
    else return n.height;
  }

  public void balanceMe(Node<K, V> n) {
    if (height(n.left) > height(n.right)+1) {
      if (n.left.left.height > n.left.right.height) {
        // rotateRight(n);
      } else {
        // rotateLeft(n.left);
        // rotateRight(n);
      }
    } else if (n.right.height > n.left.height+1) {
      // mirror image
    }
  }
}

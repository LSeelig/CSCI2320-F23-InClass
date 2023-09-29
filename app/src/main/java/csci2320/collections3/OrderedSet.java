package csci2320.collections3;

import java.util.function.Consumer;
import java.util.function.Function;

public class OrderedSet<E extends Comparable<E>> {
  private static class Node<E extends Comparable<E>> {
    E data;
    E min, max;
    Node<E> left, right;
    Node(E data, Node<E> left, Node<E> right) {
      this.data = data;
      this.min = data;
      this.max = data;
      this.left = left;
      this.right = right;
    }
    void checkMinMax(E newValue) {
      if (newValue.compareTo(min) < 0) min = newValue;
      if (newValue.compareTo(max) > 0) max = newValue;
    }
  }
  private Node<E> root = null;

  public int height() {
    return heightRecur(root);
  }

  private int heightRecur(Node<E> n) {
    if (n == null) return 0;
    else return Math.max(heightRecur(n.left), heightRecur(n.right)) + 1;
  }

  public int size() {
    return sizeRecur(root);
  }

  private int sizeRecur(Node<E> n) {
    if (n == null) return 0;
    else return sizeRecur(n.left) + sizeRecur(n.right) + 1;
  }

  // Write traversals!!!


  boolean add(E elem) {
    if (root == null) {
      root = new Node<E>(elem, null, null);
      return true;
    } else {
      Node<E> rover = root;
      Node<E> trailer = root;
      int comp = 0;
      while (rover != null && !elem.equals(rover.data)) {
        rover.checkMinMax(elem);
        comp = elem.compareTo(rover.data);
        trailer = rover;
        if (comp < 0) rover = rover.left;
        else rover = rover.right;
      }
      if (rover != null) return false;
      else {
        if (comp < 0) trailer.left = new Node<E>(elem, null, null);
        else trailer.right = new Node<E>(elem, null, null);
        return true;
      }
    }
  }

  boolean contains(E elem) {
    Node<E> rover = root;
    while (rover != null && !elem.equals(rover.data)) {
      int comp = elem.compareTo(rover.data);
      if (comp < 0) rover = rover.left;
      else rover = rover.right;
    }
    return rover != null;
  }

  public OrderedSet<E> valuesInRange(E min, E max) {
    OrderedSet<E> set = new OrderedSet<>();
    valuesInRangeRecur(min, max, root, set);
    return set;
  }

  private void valuesInRangeRecur(E min, E max, Node<E> n, OrderedSet<E> set) {
    if (n != null && min.compareTo(n.max) <= 0 && max.compareTo(n.min) >= 0) {
      if (n.data.compareTo(min) >= 0 && n.data.compareTo(max) <= 0) set.add(n.data);
      valuesInRangeRecur(min, max, n.left, set);
      valuesInRangeRecur(min, max, n.right, set);
    }
  }

  public String toStringPreorder() {
    StringBuilder sb = new StringBuilder("pre: ");
    preorder(root, e -> sb.append(e + " "));
    return sb.toString();
  }

  private void preorder(Node<E> n, Consumer<E> visitor) {
    if (n != null) {
      visitor.accept(n.data);
      preorder(n.left, visitor);
      preorder(n.right, visitor);
    }
  }

  public String toStringPostorder() {
    StringBuilder sb = new StringBuilder("post: ");
    postorder(root, e -> sb.append(e + " "));
    return sb.toString();
  }

  private void postorder(Node<E> n, Consumer<E> visitor) {
    if (n != null) {
      postorder(n.left, visitor);
      postorder(n.right, visitor);
      visitor.accept(n.data);
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("OrderedSet(");
    inorder(root, e -> sb.append(e + " "));
    sb.append(")");
    return sb.toString();
  }

  private void inorder(Node<E> n, Consumer<E> visitor) {
    if (n != null) {
      inorder(n.left, visitor);
      visitor.accept(n.data);
      inorder(n.right, visitor);
    }
  }
}

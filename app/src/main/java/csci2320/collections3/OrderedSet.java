package csci2320.collections3;

public class OrderedSet<E extends Comparable<E>> {
  private static class Node<E extends Comparable<E>> {
    E data;
    Node<E> left, right;
    Node(E data, Node<E> left, Node<E> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
  private Node<E> root = null;

  boolean add(E elem) {
    if (root == null) {
      root = new Node<E>(elem, null, null);
      return true;
    } else {
      Node<E> rover = root;
      Node<E> trailer = null;
      int comp = 0;
      while (rover != null && !elem.equals(rover.data)) {
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

  OrderedSet<E> valuesInRange(E min, E max) {
    return null;
  }
}

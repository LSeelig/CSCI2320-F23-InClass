package csci2320.collections1;

public class OrderedSet<E extends Comparable<E>> {
  private static class Node<E> {
    E data;
    Node<E> left, right;
    Node(E data, Node<E> left, Node<E> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  private Node<E> root = null;

  public boolean add(E elem) {
    if (root == null) {
      root = new Node<E>(elem, null, null);
      return true;
    } else {
      Node<E> rover = root;
      Node<E> trailer = root;
      int comp = 0;
      while (rover != null && !rover.data.equals(elem)) {
        comp = elem.compareTo(rover.data);
        trailer = rover;
        if (comp < 0) rover = rover.left;
        else rover = rover.right;
      }
      if (rover != null) {
        return false;
      } else {
        if (comp < 0) trailer.left = new Node<E>(elem, null, null);
        else trailer.right = new Node<E>(elem, null, null);
        return true;
      }
    }
  }

  public boolean contains(E elem) {
    Node<E> rover = root;
    while (rover != null && !rover.data.equals(elem)) {
      int comp = elem.compareTo(rover.data);
      if (comp < 0) rover = rover.left;
      else rover = rover.right;
    }
    return rover != null;
  }

  public OrderedSet<E> subsetBetween(E min, E max) {
    return null;
  }
}

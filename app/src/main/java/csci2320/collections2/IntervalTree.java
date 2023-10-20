package csci2320.collections2;

import java.util.Optional;

public class IntervalTree<E extends Comparable<E>> {
  private static class Node<E extends Comparable<E>> {
    Interval<E> interval;
    E max;
    Node<E> left, right;
  }

  private Node<E> root = null;

  // Code to build a tree here.

  public Optional<Interval<E>> overlappingInterval(Interval<E> interval) {
    Node<E> rover = root;
    while (rover != null && !interval.overlap(rover.interval)) {
      if (rover.left != null && rover.left.max.compareTo(interval.min()) > 0) {
        rover = rover.left;
      } else {
        rover = rover.right;
      }
    }
    if (rover == null) return Optional.empty();
    else return Optional.of(rover.interval);
  }
}

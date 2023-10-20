package csci2320.collections1;

import java.util.Optional;

public class IntervalTree<E extends Comparable<E>> {
  private static class Node<E extends Comparable<E>> {
    Interval<E> interval;
    E max;
    Node<E> left, right;
    // Constructor goes here
  }

  Node<E> root = null;

  // Code that builds the tree.

  public Optional<Interval<E>> overlappingInterval(Interval<E> interval) {
    Node<E> rover = root;
    while (rover != null && !rover.interval.overlaps(interval)) {
      if (interval.min().compareTo(rover.left.max) < 0) {
        rover = rover.left;
      } else {
        rover = rover.right;
      }
    }
    if (rover == null) return Optional.empty();
    else return Optional.of(rover.interval);
  }
}

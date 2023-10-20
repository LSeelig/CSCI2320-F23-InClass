package csci2320.collections3;

import java.util.Optional;

// import java.util.Iterator;

public class IntervalTree<E extends Comparable<E>> {
  private static class Node<E extends Comparable<E>> {
    Interval<E> interval;
    E max;
    Node<E> left, right;
    // Constructor and such here.
  }

  private Node<E> root = null;

  // Code goes here for building it.

  public Optional<Interval<E>> overlappingInterval(Interval<E> interval) {
    Node<E> rover = root;
    while(rover != null && !rover.interval.overlaps(interval)) {
      if (rover.left != null && rover.left.max.compareTo(interval.min()) > 0) {
        rover = rover.left;
      } else {
        rover = rover.right;
      }
    }
    if (rover == null) return Optional.empty();
    else return Optional.of(rover.interval);
  }

  private static int[] data = new int[100];

  private static int twice(int i) {
    return i*2;
  }

  private static void sideEffects(int i, int v) {
    data[i] = v;
    System.out.println("Hi there");
    var x = Math.random();
    var j = 8; //twice(4);
    // new Iterator<Integer>() {
    //   @Override
    //   public boolean hasNext() {
    //     return j < 100;
    //   }

    //   @Override
    //   public Integer next() {
    //     return ++j;
    //   }
    // };
      
  }
}

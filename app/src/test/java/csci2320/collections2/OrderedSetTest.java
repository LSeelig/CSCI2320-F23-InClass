package csci2320.collections2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrderedSetTest {
  @Test void addContains() {
    var set = new OrderedSet<Integer>();
    assertTrue(set.add(5));
    assertTrue(set.add(3));
    assertTrue(set.add(8));
    assertTrue(set.add(6));
    assertTrue(set.add(2));
    assertTrue(set.add(1));
    assertTrue(set.add(9));
    assertFalse(set.add(3));
    System.out.println(set.toStringPreorder());
    System.out.println(set.toStringPostorder());
    System.out.println(set.toString());
    set.printInOrder();
    assertTrue(set.contains(5));
    assertTrue(set.contains(8));
    assertTrue(set.contains(6));
    assertTrue(set.contains(9));
    assertTrue(set.contains(1));
    assertFalse(set.contains(4));
  }

  @Test void subrange() {
    var set = new OrderedSet<Integer>();
    assertTrue(set.add(5));
    assertTrue(set.add(3));
    assertTrue(set.add(8));
    assertTrue(set.add(6));
    assertTrue(set.add(2));
    assertTrue(set.add(1));
    assertTrue(set.add(9));
    var subset = set.searchRange(4, 6);
    assertTrue(subset.contains(5));
    assertTrue(subset.contains(6));
    assertFalse(subset.contains(4));
    assertFalse(subset.contains(8));
  }
}

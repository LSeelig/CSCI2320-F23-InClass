package csci2320.collections3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrderedSetTest {
  @Test void addContains() {
    OrderedSet<Integer> set = new OrderedSet<>();
    assertTrue(set.add(5));
    assertTrue(set.add(3));
    assertTrue(set.add(1));
    assertTrue(set.add(7));
    assertTrue(set.add(2));
    assertTrue(set.add(6));
    assertTrue(set.add(-4));
    assertFalse(set.add(7));
    assertTrue(set.contains(5));
    assertTrue(set.contains(3));
    assertTrue(set.contains(6));
    assertTrue(set.contains(2));
    assertTrue(set.contains(1));
    assertFalse(set.contains(8));
    assertTrue(set.contains(-4));
  }

  @Test void valuesInRange() {
    OrderedSet<Integer> set = new OrderedSet<>();
    assertTrue(set.add(5));
    assertTrue(set.add(3));
    assertTrue(set.add(1));
    assertTrue(set.add(7));
    assertTrue(set.add(2));
    assertTrue(set.add(6));
    System.out.println(set.toStringPreorder());
    System.out.println(set.toStringPostorder());
    System.out.println(set.toString());
    var subset = set.valuesInRange(4, 6);
    assertFalse(subset.contains(4));
    assertTrue(subset.contains(5));
    assertTrue(subset.contains(6));
    assertFalse(subset.contains(7));
    assertFalse(subset.contains(0));
  }
}

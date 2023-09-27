package csci2320.collections3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrderedSetTest {
  @Test void addContains() {
    OrderedSet<Integer> set = new OrderedSet<>();
    set.add(5);
    set.add(3);
    set.add(1);
    set.add(7);
    set.add(2);
    set.add(6);
    assertTrue(set.contains(5));
    assertTrue(set.contains(3));
    assertTrue(set.contains(6));
    assertTrue(set.contains(2));
    assertTrue(set.contains(1));
    assertFalse(set.contains(8));
  }
}

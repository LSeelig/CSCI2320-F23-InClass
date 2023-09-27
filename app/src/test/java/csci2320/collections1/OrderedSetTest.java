package csci2320.collections1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrderedSetTest {
  @Test void addContains() {
    var set = new OrderedSet<Integer>();
    assertTrue(set.add(5));
    assertTrue(set.add(2));
    assertTrue(set.add(6));
    assertTrue(set.add(1));
    assertTrue(set.add(4));
    assertTrue(set.add(3));
    assertTrue(set.add(8));
    assertTrue(set.add(7));
    assertFalse(set.add(6));
    assertTrue(set.contains(5));
    assertTrue(set.contains(4));
    assertTrue(set.contains(6));
    assertTrue(set.contains(1));
    assertTrue(set.contains(7));
    assertFalse(set.contains(10));
  }
}

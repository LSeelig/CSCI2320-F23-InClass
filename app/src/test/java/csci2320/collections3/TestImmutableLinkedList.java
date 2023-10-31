package csci2320.collections3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestImmutableLinkedList {
  @Test void basicTests() {
    var nil = ImmutableLinkedList.<Integer>Empty();
    assertEquals(0, nil.size());
    var lst = nil.cons(3).cons(2);
    assertEquals(2, lst.head());
    assertEquals(3, lst.tail().head());
    assertEquals(2, lst.size());
    assertEquals(nil.cons(6).cons(4), lst.map(i -> i*2));
  }
}

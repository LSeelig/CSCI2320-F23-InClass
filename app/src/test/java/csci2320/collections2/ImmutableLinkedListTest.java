package csci2320.collections2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ImmutableLinkedListTest {
  @Test void basicTests() {
    var nil = new ImmutableLinkedList.Nil<Integer>();
    assertTrue(nil.isEmpty());
    assertEquals(0, nil.size());
    var lst = nil.cons(3).cons(2).cons(1);
    assertEquals(1, lst.head());
    assertEquals(2, lst.tail().head());
    assertEquals(3, lst.get(2));
    assertEquals(3, lst.size());
    assertEquals(nil.cons(6).cons(4).cons(2), lst.map(i -> i*2));
  }
}

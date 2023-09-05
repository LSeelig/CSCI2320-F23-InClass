package csci2320.collections2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedSeqTest {
  private LinkedSeq<Integer> seq;

  @BeforeEach void createSeq() {
    seq = new LinkedSeq<>();
  }
  @Test void insert3() {
    seq.add(5);
    seq.add(10);
    seq.add(15);
    assertEquals(5, seq.get(0));
    assertEquals(10, seq.get(1));
    assertEquals(15, seq.get(2));
  }

  @Test void iterator() {
    seq.add(5);
    seq.add(10);
    seq.add(15);
    Iterator<Integer> iter = seq.iterator();
    assertEquals(5, iter.next());
    assertEquals(10, iter.next());
    assertEquals(15, iter.next());
    assertFalse(iter.hasNext());
  }

  // @Test(expected = IndexOutOfBoundsException.class)
  // void badIndex() {
  //   seq.get(-5);
  // }
}

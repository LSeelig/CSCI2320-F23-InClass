package csci2320.collections2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Test
  void badIndex() {
    assertThrows(IndexOutOfBoundsException.class, () -> seq.get(-5));
  }

  @Test void testFoldLeft() {
    seq.add(5);
    seq.add(10);
    seq.add(15);
    assertEquals(30, seq.foldLeft(0, (s, i) -> s + i));
    assertEquals("51015", seq.foldLeft("", (s, i) -> s + i));
    assertEquals(15, seq.foldLeft(0, (s, i) -> Math.max(s, i)));
  }

  // (3, 4, 5, 9, 2, 7, 4).removeWhile(i -> i < 6)  ===> (9, 2, 7, 4)
  // (3, 4, 5, 9, 2, 7, 4).keepWhile(i -> i < 6)  ===> (3, 4, 5)
}

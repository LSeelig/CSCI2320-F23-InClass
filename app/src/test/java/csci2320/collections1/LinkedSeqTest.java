package csci2320.collections1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedSeqTest {
  private LinkedSeq<Integer> seq;

  @BeforeEach void makeSeq() {
    seq = new LinkedSeq<>();
  }

  @Test void addGet2() {
    seq.add(7);
    seq.add(3);
    assertEquals(7, seq.get(0));
    assertEquals(3, seq.get(1));
  }

  @Test void testFoldLeft() {
    seq.add(7);
    seq.add(5);
    seq.add(2);
    assertEquals(14, seq.foldLeft(0, (s, i) -> s + i));
    assertEquals("752", seq.foldLeft("", (s, i) -> s + Integer.toString(i)));
  }
}

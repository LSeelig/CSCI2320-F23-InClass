package csci2320.collections3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedSeqTest {
  private LinkedSeq<Integer> seq;

  @BeforeEach void createSeq() {
    seq = new LinkedSeq<>();
  }

  @Test void emptyOnCreate() {
    assertEquals(0, seq.size());
  }

  @Test void addGet2() {
    seq.add(7);
    seq.add(5);
    assertEquals(2, seq.size());
    assertEquals(7, seq.get(0));
    assertEquals(5, seq.get(1));
  }
}

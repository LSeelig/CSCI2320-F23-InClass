package csci2320.collections3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArraySeqTest {
  @Test void insert1() {
    ArraySeq<Integer> seq = new ArraySeq<>();
    seq.insert(0, 7);
    assertEquals(7, seq.get(0));
  }
}

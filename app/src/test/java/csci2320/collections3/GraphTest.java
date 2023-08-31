package csci2320.collections3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GraphTest {
  @Test void smallGraphNoCycles() {
    List<List<Integer>> graph = List.of(
      List.of(1,2),
      List.of(2),
      List.of(3),
      List.of()
    );
    var dist = Graph.recursiveDFSShortest(0, graph, 3);
    assertEquals(2, dist, "Wrong distance on simple graph with no cycles.");
  }

  @Test void smallGraphCycles() {
    List<List<Integer>> graph = List.of(
      List.of(0,1,2),
      List.of(2),
      List.of(1,3),
      List.of()
    );
    var dist = Graph.recursiveDFSShortest(0, graph, 3);
    assertEquals(2, dist, "Wrong distance on simple graph with no cycles.");
  }
}

package csci2320.collections1;

import org.junit.jupiter.api.Test;

import csci2320.collections1.AGraph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AGraphTest {
  @Test
  void noCycleSmallGraph() {
    List<List<Integer>> graph = List.of(
        List.of(2, 3),
        List.of(2),
        List.of(3),
        List.of());
    var dist = AGraph.recursiveDFSShort(graph, 0, 3);
    assertEquals(1, dist, "No cycle failed.");
  }

  @Test
  void cycleSmallGraph() {
    List<List<Integer>> graph = List.of(
        List.of(0, 2, 3),
        List.of(2),
        List.of(3),
        List.of(1));
    var dist = AGraph.recursiveDFSShort(graph, 0, 3);
    assertEquals(1, dist);
  }
}

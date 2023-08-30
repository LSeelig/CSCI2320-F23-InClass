package csci2320.collections1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AGraph {
  int[][] matrix = { { 1, 0, 1, 1 },
      { 0, 0, 1, 0 },
      { 0, 0, 0, 1 },
      { 0, 1, 0, 0 } };
  List<List<Integer>> adjList = List.of(
      List.of(0, 2, 3),
      List.of(2),
      List.of(3),
      List.of(1));

  int[][] maze = {
      { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
      { 0, 1, 0, 1, 0, 1, 1, 0, 1, 0 },
      { 0, 1, 0, 1, 0, 1, 0, 0, 1, 0 },
      { 0, 1, 0, 1, 1, 1, 1, 1, 1, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
      { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
      { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
      { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
      { 0, 1, 0, 0, 0, 1, 0, 0, 1, 0 }
  };

  public static int recursiveDFSShort(List<List<Integer>> graph, int current, int end) {
    Set<Integer> empty = new HashSet<Integer>();
    return recursiveDFSShort(graph, current, end, empty);
  }

  private static int recursiveDFSShort(List<List<Integer>> graph, int current, int end, Set<Integer> visited) {
    if (current == end) {
      return 0;
    } else {
      int min = 1000000000;
      Set<Integer> newVisited = new HashSet<>(visited);
      newVisited.add(current);
      for (int dest : graph.get(current)) {
        if (!newVisited.contains(dest)) {
          int dist = recursiveDFSShort(graph, dest, end, newVisited);
          if (dist < min)
            min = dist;
        }
      }
      return min + 1;
    }
  }

  /**
   * This is a static factory.
   * @return An empty graph if that were meainingful here.
   */
  public static AGraph emptyGraph() {
    // ...
    return new AGraph();
  }
}

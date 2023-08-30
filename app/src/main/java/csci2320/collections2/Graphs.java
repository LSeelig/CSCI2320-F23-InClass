package csci2320.collections2;

import java.util.List;
import java.util.Set;

public class Graphs {
  int[][] matrix = {
    {1,1,1,0},
    {0,0,1,1},
    {0,0,0,1},
    {0,1,0,0}
  };

  List<Set<Integer>> adjList = List.of(
    Set.of(0,1,2),
    Set.of(2,3),
    Set.of(3),
    Set.of(1)
  );

  int[][] maze = {
    {0,1,0,0,0,0,0,0,0,0},
    {0,1,0,1,1,1,0,0,1,0},
    {0,1,0,0,0,1,0,0,1,0},
    {0,1,1,1,0,1,1,1,1,0},
    {0,0,0,0,0,0,0,0,1,0},
    {0,1,1,1,1,0,1,1,1,0},
    {0,1,0,0,0,0,0,0,1,0},
    {0,1,0,1,1,1,1,0,1,0},
    {0,1,0,1,0,0,1,0,1,0},
    {0,1,0,0,0,0,0,0,1,0}
  };

  public static Graphs makeEmpty() {
    return new Graphs();
  }

  public int recursiveDFSShort(List<Set<Integer>> graph, int current, int end) {
    if (current == end) {
      return 0;
    } else {
      for (int dest: graph.get(current)) {
        int dist = recursiveDFSShort(graph, dest, end);
      }
    }
    return 0;
  }
}

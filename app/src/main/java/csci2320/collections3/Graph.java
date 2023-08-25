package csci2320.collections3;

import java.util.List;

public class Graph {
  static int[][] matrix = {
    {1,1,1,0},
    {0,0,1,1},
    {0,0,0,1},
    {0,1,0,0}
  };

  static List<List<Integer>> adjList = List.of(
    List.of(0,1,2),
    List.of(2,3),
    List.of(3),
    List.of(1)
  );

  static int[][] maze = {
    {0,1,0,0,0,0,0,0,0,0},
    {0,1,0,1,1,1,1,0,1,0},
    {0,1,0,1,0,0,1,0,1,0},
    {0,1,0,0,0,0,1,0,1,0},
    {0,1,1,1,1,0,1,1,1,0},
    {0,0,0,0,0,0,0,0,1,0},
    {0,1,1,1,0,1,1,1,1,0},
    {0,1,0,0,0,0,0,0,1,0},
    {0,1,0,1,1,1,1,0,1,0},
    {0,1,0,0,1,0,0,0,1,0}
  };

  public static int recursiveDFSShortest(int current, List<List<Integer>> adj, int end) {
    if (current == end) {
      return 0;
    } else {
      int min = 1000000000;
      for (int dest: adj.get(current)) {
        int dist = recursiveDFSShortest(dest, adj, end);
        if (dist < min) min = dist;
      }
      return min+1;
    }
  }
}

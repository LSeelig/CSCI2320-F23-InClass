package csci2320.collections3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
  static int[][] matrix = {
      { 1, 1, 1, 0 },
      { 0, 0, 1, 1 },
      { 0, 0, 0, 1 },
      { 0, 1, 0, 0 }
  };

  static List<List<Integer>> adjList = List.of(
      List.of(0, 1, 2),
      List.of(2, 3),
      List.of(3),
      List.of(1));

  static int[][] maze = {
      { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
      { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0 },
      { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0 },
      { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
      { 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
      { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 },
      { 0, 1, 0, 1, 1, 1, 1, 0, 1, 0 },
      { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0 }
  };

  public static int recursiveDFSShortest(int current, List<List<Integer>> adj, int end) {
    return recursiveDFSShortestRecur(current, adj, end, new HashSet<Integer>());
  }

  private static int recursiveDFSShortestRecur(int current, List<List<Integer>> adj, int end, Set<Integer> visited) {
    if (current == end) {
      return 0;
    } else {
      int min = 1000000000;
      Set<Integer> newVisited = new HashSet<Integer>(visited);
      newVisited.add(current);
      for (int dest : adj.get(current)) {
        if (!newVisited.contains(dest)) {
          int dist = recursiveDFSShortestRecur(dest, adj, end, newVisited);
          if (dist < min)
            min = dist;
        }
      }
      return min + 1;
    }
  }
}

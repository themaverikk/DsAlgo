package com.ds.main;

import java.util.Arrays;

public class DijkstraForMatrix {

  public static void main(String[] args) {
    int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 6}, {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};

    ShortestPath t = new ShortestPath();
    t.dijkstra(graph, 0);
  }

}

class ShortestPath {

  public void dijkstra(int[][] graph, int src) {
    int verticesCount = graph.length;
    boolean[] visited = new boolean[verticesCount];
    int[] distance = new int[verticesCount];
    int[] parent = new int[verticesCount];

    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[src] = 0;
    parent[src] = -1;

    int visitedVertices = 0;
    while (visitedVertices < verticesCount) {
      int nextVertex = getMinDistanceUnvisitedVertex(visited, distance);
      visited[nextVertex] = true;
      visitedVertices++;

      for (int i = 0; i < verticesCount; i++) {
        if (graph[nextVertex][i] > 0 && distance[nextVertex] + graph[nextVertex][i] < distance[i]) {
          distance[i] = distance[nextVertex] + graph[nextVertex][i];
          parent[i] = nextVertex;
        }
      }
    }

    printSolution(distance, parent);
  }

  private void printSolution(final int[] distance, int[] parent) {
    System.out.println("Vertex | Path");

    for (int i = 0; i < distance.length; i++) {
      System.out.print(i + " (" + distance[i] + ") | ");
      printPath(parent, i);
      System.out.println();
    }
  }

  private void printPath(int[] parent, int i) {
    if (i == -1) {
      return;
    }

    printPath(parent, parent[i]);
    System.out.print(i + " -> ");
  }

  private int getMinDistanceUnvisitedVertex(final boolean[] visited, final int[] distance) {
    int minDistanceVertex = -1;

    for (int i = 0; i < distance.length; i++) {
      if (!visited[i] && (minDistanceVertex == -1 || distance[i] < distance[minDistanceVertex])) {
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
  }
}

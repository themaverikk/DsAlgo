package com.ds.main;

import java.util.Scanner;

public class FloydWarshall {

  public static void main(String[] args) {
    AllPairShortestPath a = new AllPairShortestPath();

    Scanner console = new Scanner(System.in);
    int testCases = console.nextInt();

    for (; testCases > 0; testCases--) {
      int n = console.nextInt();
      int[][] graph = new int[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          graph[i][j] = console.nextInt();
        }
      }

      a.floydWarshall(graph);
    }
  }

}

class AllPairShortestPath {

  public void floydWarshall(int[][] graph) {
    int vertices = graph.length;
    int[][] distance = new int[vertices][vertices];

    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        distance[i][j] = graph[i][j];
      }
    }

    for (int k = 0; k < vertices; k++) {
      for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++) {
          if (distance[i][k] + distance[k][j] < distance[i][j]) {
            distance[i][j] = distance[i][k] + distance[k][j];
          }
        }
      }
    }

    for (int i = 0; i < vertices; i++) {
      for (int j = 0; j < vertices; j++) {
        System.out.print(distance[i][j] + " ");
      }
    }
  }
}

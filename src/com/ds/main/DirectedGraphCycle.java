package com.ds.main;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraphCycle {

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    if (graph.isCyclic()) {
      System.out.println("Graph contains cycle");
    } else {
      System.out.println("Graph doesn't contain cycle");
    }
  }
}

class Graph {

  private int verticesCount;
  private List<Integer>[] adj;

  public Graph(int verticesCount) {
    this.verticesCount = verticesCount;
    adj = new List[verticesCount];

    for (int i = 0; i < verticesCount; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
  }

  public boolean isCyclic() {
    boolean[] visited = new boolean[verticesCount];
    boolean[] recStack = new boolean[verticesCount];

    for (int i = 0; i < verticesCount; i++) {
      if (isCyclic(i, visited, recStack)) {
        return true;
      }
    }

    return false;
  }

  private boolean isCyclic(int vertex, boolean[] visited, boolean[] recStack) {

    if (recStack[vertex]) {
      return true;
    }

    if (visited[vertex]) {
      return false;
    }

    visited[vertex] = true;
    recStack[vertex] = true;

    for (int child : adj[vertex]) {
      if (isCyclic(child, visited, recStack)) {
        return true;
      }
    }

    recStack[vertex] = false;

    return false;

  }
}
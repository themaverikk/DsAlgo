package com.ds.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DisjointSetCycle {

  public static void main(String[] args) {
    UndirectedGraph graph = new UndirectedGraph(3);

    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(0, 2);

    if (graph.isCyclic()) {
      System.out.println("graph contains cycle");
    } else {
      System.out.println("graph doesn't contain cycle");
    }
  }

}

class UndirectedGraph {

  private int verticesCount;
  private List<List<Integer>> adj;


  public UndirectedGraph(int verticesCount) {
    this.verticesCount = verticesCount;
    adj = new LinkedList<>();

    for (int i = 0; i < verticesCount; i++) {
      adj.add(new LinkedList<>());
    }
  }

  public void addEdge(int src, int dest) {
    adj.get(src).add(dest);
    adj.get(dest).add(src);
  }

  public boolean isCyclic() {
    DisjointSet disjointSet = new DisjointSet(verticesCount);

    for (int parent = 0; parent < verticesCount; parent++) {
      for (int child : adj.get(parent)) {
        int parentGroup = disjointSet.find(parent);
        int childGroup = disjointSet.find(child);

        if (parentGroup == childGroup) {
          return true;
        }
        disjointSet.union(parent, child);
      }
    }
    return false;
  }
}

class DisjointSet {

  private int[] parent;
  private int[] rank;

  public DisjointSet(int n) {
    parent = new int[n];
    Arrays.fill(parent, -1);

    rank = new int[n];
  }

  public int find(int u) {
    if (parent[u] == -1) {
      return u;
    }

    return parent[u] = find(parent[u]);
  }

  public void union(int u, int v) {
    int uParent = find(u);
    int vParent = find(v);

    if (uParent == vParent) {
      return;
    }

    if (rank[uParent] < rank[vParent]) {
      parent[uParent] = vParent;
    } else if (rank[uParent] > rank[vParent]) {
      parent[vParent] = uParent;
    } else {
      rank[uParent]++;
      parent[vParent] = uParent;
    }
  }
}

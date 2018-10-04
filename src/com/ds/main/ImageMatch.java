package com.ds.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageMatch {

  static int countMatches(List<String> grid1, List<String> grid2) {

    int[][] g1 = convertToArray(grid1);

    int[][] g2 = convertToArray(grid2);

    Map<Integer, List<Pair>> m1 = markRegion(g1);
    Map<Integer, List<Pair>> m2 = markRegion(g2);

    int score = 0;

    for (Map.Entry<Integer, List<Pair>> entry : m1.entrySet()) {

      if (matches(entry.getValue(), m2.get(entry.getKey()))) {
        score++;
      }

    }

    return score;
  }

  private static int[][] convertToArray(final List<String> grid) {
    int[][] g = new int[grid.size()][grid.get(0).length()];

    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid.get(i).length(); j++) {
        g[i][j] = Character.getNumericValue(grid.get(i).charAt(j));
      }
    }

    return g;
  }

  private static boolean matches(final List<Pair> p1, final List<Pair> p2) {
    if (p2 == null || p1.size() != p2.size()) {
      return false;
    }

    for (int i = 0; i < p1.size(); i++) {
      if (!p1.get(i).equals(p2.get(i))) {
        return false;
      }
    }

    return true;

  }

  static Map<Integer, List<Pair>> markRegion(int[][] g) {
    int region = 2;
    Map<Integer, List<Pair>> map = new HashMap<>();

    for (int i = 0; i < g.length; i++) {
      for (int j = 0; j < g[0].length; j++) {
        markRegionUtil(g, i, j, region, map);
        region++;
      }
    }

    return map;
  }

  private static void markRegionUtil(final int[][] g, final int i, final int j, final int region,
      Map<Integer, List<Pair>> map) {
    if (i >= 0 && i < g.length && j >= 0 && j < g[0].length && g[i][j] == 1) {
      g[i][j] = region;

      if (!map.containsKey(region)) {
        map.put(region, new ArrayList<>());
      }
      map.get(region).add(new Pair(i, j));

      markRegionUtil(g, i - 1, j, region, map);
      markRegionUtil(g, i + 1, j, region, map);
      markRegionUtil(g, i, j - 1, region, map);
      markRegionUtil(g, i, j + 1, region, map);
    }
  }

  public static void main(String[] args) {
    List<String> l1 = Arrays.asList("001", "011", "100");
    List<String> l2 = Arrays.asList("001", "011", "101");

    System.out.println(countMatches(l1, l2));
  }

  static class Pair {

    int i, j;

    public Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public boolean equals(Pair p) {
      return i == p.i && j == p.j;
    }
  }
}

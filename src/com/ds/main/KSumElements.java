package com.ds.main;

import java.util.LinkedList;
import java.util.List;

public class KSumElements {

  public static List<List<Integer>> getKSumElements(int i, int[] arr, int sum) {

    if (sum == 0) {
      List<List<Integer>> groups = new LinkedList<>();
      groups.add(new LinkedList<>());
      return groups;
    }

    if (sum < 0 || i < 0 || i >= arr.length) {
      return null;
    }

    List<List<Integer>> groups = new LinkedList<>();

    List<List<Integer>> withoutCurrent = getKSumElements(i + 1, arr, sum);

    if (withoutCurrent != null) {
      groups.addAll(withoutCurrent);
    }
    List<List<Integer>> withCurrent = getKSumElements(i + 1, arr, sum - arr[i]);

    if (withCurrent != null) {
      for (List<Integer> list : withCurrent) {
        list.add(0, arr[i]);
        groups.add(list);
      }
    }

    return groups;
  }
}

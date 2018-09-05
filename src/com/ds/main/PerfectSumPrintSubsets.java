package com.ds.main;

import java.util.ArrayList;
import java.util.List;

public class PerfectSumPrintSubsets {

  private static List<List<Integer>>[][] dp;

  public static void main(String[] args) {
    int arr[] = {2, 3, 5, 6, 8, 10};
    int sum = 10;

    dp = new List[arr.length][sum + 1];

    printAllSubsets(arr, sum);
  }

  public static void printAllSubsets(int[] arr, int sum) {
    List<List<Integer>> subsets = perfectSumCombination(arr, arr.length - 1, sum);

    if (subsets != null) {
      for (List<Integer> subset : subsets) {
        System.out.println(subset);
      }
    }
  }

  public static List<List<Integer>> perfectSumCombination(int[] arr, int i, int sum) {

    if (sum == 0) {
      List<List<Integer>> currentList = new ArrayList<>();
      currentList.add(new ArrayList<>());
      return currentList;
    }

    if (i < 0 || sum < 0) {
      return null;
    }

    if (dp[i][sum] != null) {
      return dp[i][sum];
    }

    List<List<Integer>> without = perfectSumCombination(arr, i - 1, sum);
    List<List<Integer>> with = perfectSumCombination(arr, i - 1, sum - arr[i]);

    List<List<Integer>> currentList = new ArrayList<>();

    if (without != null) {
      currentList.addAll(without);
    }

    if (with != null) {
      for (List<Integer> list : with) {
        List<Integer> tempList = new ArrayList<>();
        tempList.addAll(list);
        tempList.add(arr[i]);
        currentList.add(tempList);
      }
    }

    return dp[i][sum] = currentList;
  }
}

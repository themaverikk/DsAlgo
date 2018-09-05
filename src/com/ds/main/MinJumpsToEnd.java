package com.ds.main;

public class MinJumpsToEnd {

  public static void main(String[] args) {
    int arr[] = {1, 3, 6, 1, 0, 5, 1, 3, 6, 1, 0, 3, 1, 3, 6, 1, 0, 5, 1, 3, 6, 1, 0, 5, 1, 3, 6, 1,
        0, 5, 1, 3, 6, 1, 0, 3, 1, 3, 6, 1, 0, 5, 1, 3, 6, 1, 0, 5, 1, 3, 6, 1, 0, 5, 1, 3, 6, 1, 0,
        0, 5, 1, 3, 6, 1, 0, 3, 1, 3, 6, 1, 1, 2, 3, 5, 2};

    int dp[] = new int[arr.length];

    long start = System.currentTimeMillis();
    System.out.println("Minimum number of jumps to reach end is " + minJumps(arr, dp, 0));
    System.out.println(System.currentTimeMillis() - start);
  }

  public static int minJumps(int[] arr, int[] dp, int i) {
    if (i >= arr.length) {
      return 0;
    }

    if (dp[i] != 0) {
      return dp[i];
    }

    if (i + arr[i] >= arr.length - 1) {
      dp[i] = 1;
      return 1;
    }

    int minSteps = Integer.MAX_VALUE;

    for (int j = 1; j <= arr[i]; j++) {
      minSteps = Math.min(minSteps, minJumps(arr, dp, i + j));
    }

    return dp[i] = minSteps == Integer.MAX_VALUE ? Integer.MAX_VALUE : minSteps + 1;
  }

}

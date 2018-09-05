package com.ds.main;

import java.util.Scanner;

public class StringPartitionWithMinSum {

  static long dp[][];

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    in.nextInt();
    int k = in.nextInt();
    long z = in.nextLong();
    char[] input = in.next().toCharArray();

    dp = new long[input.length][k + 1];

    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j] = -1;
      }
    }
    long val = minSum(0, k, input, z);
    if (val != Long.MAX_VALUE) {
      System.out.println(val);
    } else {
      System.out.println(1);
    }
  }

  public static long minSum(int i, int k, char[] input, long max) {
    if (k < 0) {
      return Long.MAX_VALUE;
    }
    if (i == input.length) {
      if (k == 0) {
        return 0;
      }
      return Long.MAX_VALUE;
    }
    if (dp[i][k] != -1) {
      return dp[i][k];
    }
    long val = 0;
    long ans = Long.MAX_VALUE;

    for (int j = i; j < input.length; j++) {
      val = val * 10 + (input[j] - 48);

      if (val > max) {
        break;
      }

      long remainingMaxSum = minSum(j + 1, k - 1, input, max);

      if (remainingMaxSum != Long.MAX_VALUE && val + remainingMaxSum < ans) {
        ans = val + remainingMaxSum;
      }

    }
    return dp[i][k] = ans;

  }
}
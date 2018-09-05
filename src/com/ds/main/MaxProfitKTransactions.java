package com.ds.main;

public class MaxProfitKTransactions {

  public static int maxProfit(int[] price, int k) {
    int[][] profit = new int[k + 1][price.length];

    for (int trans = 1; trans <= k; trans++) {
      int maxDiff = Integer.MIN_VALUE;

      for (int day = 1; day < price.length; day++) {

        maxDiff = Math.max(maxDiff, profit[trans - 1][day - 1] - price[day - 1]);

        profit[trans][day] = Math.max(profit[trans][day - 1], price[day] + maxDiff);
      }
    }

    return profit[k][price.length - 1];
  }

  public static void main(String[] args) {
    int k = 3;
    int price[] = {12, 14, 17, 10, 14, 13, 12, 15};

    System.out.println("Maximum profit is: " + maxProfit(price, k));
  }
}

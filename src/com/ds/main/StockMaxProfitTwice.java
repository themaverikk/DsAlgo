package com.ds.main;

public class StockMaxProfitTwice {

  public static void main(String[] args) {
    int[] price = {2, 30, 45, 50, 80, 70, 100};

    System.out.println(maxProfit(price));
  }

  public static int maxProfit(int[] price) {
    int[] maxLeftProfit = new int[price.length];

    maxLeftProfit[0] = 0;

    int min = price[0];

    for (int i = 1; i < price.length; i++) {
      min = Math.min(min, price[i]);
      maxLeftProfit[i] = Math.max( maxLeftProfit[i - 1], price[i] - min);
    }

    int max = price[price.length - 1], maxProfit = maxLeftProfit[maxLeftProfit.length - 1];
    for (int i = price.length - 1; i > 0; i--) {
      max = Math.max(max, price[i]);
      maxProfit = Math.max(maxProfit, maxLeftProfit[i - 1] + max - price[i]);
    }

    return maxProfit;
  }

}

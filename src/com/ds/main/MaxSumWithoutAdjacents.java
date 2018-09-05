package com.ds.main;

public class MaxSumWithoutAdjacents {

  public static void main(String[] args) {
    int[] arr = {6, 7, 1, 3, 8, 2, 4};

    System.out.println(maxSumWithoutAdjacents(arr));
  }

  public static int maxSumWithoutAdjacents(int[] arr) {

    int sumWithoutPrevElement = 0, sumWithPrevElement = arr[0];
    int sumWithoutCurrElement = 0, sumWithCurrElement = 0;

    for (int i = 1; i < arr.length; i++) {
      sumWithoutCurrElement = Math.max(sumWithoutPrevElement, sumWithPrevElement);
      sumWithCurrElement = sumWithoutPrevElement + arr[i];

      sumWithoutPrevElement = sumWithoutCurrElement;
      sumWithPrevElement = sumWithCurrElement;
    }

    return Math.max(sumWithoutPrevElement, sumWithPrevElement);

  }
}

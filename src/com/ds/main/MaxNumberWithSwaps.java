package com.ds.main;

public class MaxNumberWithSwaps {

  public static void main(String[] args) {
    String number = "129814999";
    int k = 4;
    System.out.println(maxNumberWithSwaps(number.toCharArray(), 0, k));
  }

  public static String maxNumberWithSwaps(final char[] number, final int i, final int k) {

    if (k < 0 || i >= number.length) {
      return String.valueOf(number);
    }

    int maxNumber = Integer.parseInt(String.valueOf(number));

    for (int j = i + 1; j < number.length; j++) {
      if (number[j] > number[i]) {
        swap(number, i, j);
        maxNumber = Math.max(maxNumber, Integer.parseInt(maxNumberWithSwaps(number, i + 1, k - 1)));
        swap(number, i, j);
      }
    }

    return String.valueOf(maxNumber);
  }

  public static void swap(char[] number, int i, int j) {
    char temp = number[i];
    number[i] = number[j];
    number[j] = temp;
  }
}

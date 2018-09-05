package com.ds.main;

public class LPC {


  public static int LPC(String str, int low, int high) {
    if (low < 0 || low >= str.length() || high < 0 || high >= str.length() || low > high) {
      return 0;
    }

    int matchingIndex = str.lastIndexOf(str.charAt(low), high);

    if (matchingIndex == low) {
      return 1;
    }

    int chunkLength = high - matchingIndex + 1;

    if (!str.substring(low, low + chunkLength)
        .equalsIgnoreCase(str.substring(matchingIndex, high + 1))) {
      return 1;
    }

    return 2 + LPC(str, low + chunkLength, matchingIndex - 1);

  }
}

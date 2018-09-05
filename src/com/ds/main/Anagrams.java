package com.ds.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagrams {

  public static List<String> anagrams(String str, int i) {
    if (i < 0 || i >= str.length()) {
      return null;
    }

    if (i == str.length() - 1) {
      return Collections.singletonList(String.valueOf(str));
    }

    List<String> currentAnagrams = new ArrayList<>();

    for (int j = i; j < str.length(); j++) {
      List<String> anagrams = anagrams(str.charAt(j) + str.substring(0, j) + str.substring(j + 1),
          i + 1);

      if (anagrams != null) {
        currentAnagrams.addAll(anagrams);
      }
    }

    return currentAnagrams;
  }
}

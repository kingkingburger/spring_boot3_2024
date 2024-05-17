package hello;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public String[] findRelativeRanks(int[] score) {
    Integer[] sortedScore =
        Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
    String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};

    Map<Integer, String> rankMapping = new HashMap<>();

    for (int i = 0; i < sortedScore.length; i++) {
      if (i < 3) {
        rankMapping.put(sortedScore[i], medal[i]);
      } else {
        rankMapping.put(sortedScore[i], String.valueOf(i + 1));
      }
    }

    String[] result = new String[sortedScore.length];
    for (int i = 0; i < sortedScore.length; i++) {
      result[i] = rankMapping.get(score[i]);
    }
    return result;
  }
}

package hello;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
  public static long maximumHappinessSum(int[] happiness, int k) {
    long answer = 0;
    Integer[] sortedHappiness =
        Arrays.stream(happiness).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

    for (int i = 0; i < k; i++) {
      int max = sortedHappiness[i] - i;
      if (max > 0) {
        answer += max;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    maximumHappinessSum(new int[] {1, 2, 3}, 2); // 4
    maximumHappinessSum(new int[] {1, 1, 1, 1}, 2); // 1
    maximumHappinessSum(new int[] {2, 3, 4, 5}, 1); // 5
    maximumHappinessSum(new int[] {12, 1, 42}, 3); // 53
    maximumHappinessSum(
        new int[] {
          2135218, 73431904, 92495076, 77528042, 82824634, 3036629, 28375907, 65220365, 40948869,
          58914871, 57169530, 89783499, 19582915, 19676695, 11932465, 21770144, 49740276, 22303751,
          80746555, 97391584, 95775653, 43396943, 47271136, 43935930, 59643137, 64183008, 8892641,
          39587569, 85086654, 5663585, 82925096, 24868817, 95900395, 48155864, 74447380, 7618448,
          63299623, 91141186, 33347112, 81951555, 52867615, 92184410, 7024265, 85525916, 29846922,
          59532692, 47267934, 6514603, 1137830, 97807470
        },
        41); // 2517853814
  }
}

import java.util.*;

import static java.util.Arrays.*;

public class DynamicProgramming {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> t) {
        int[] dp = new int[t.size() + 1];
        int pos = 0;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).size() == 1) dp[i] = t.get(i).get(pos);
            else {
                if (pos == t.get(i).size() - 1) {
                    dp[i] = dp[i - 1] + t.get(i).get(pos);
                } else {
                    if (t.get(i).get(pos) < t.get(i).get(pos + 1)) {
                        dp[i] = dp[i - 1] + t.get(i).get(pos);
                    } else {
                        dp[i] = dp[i - 1] + t.get(i).get(pos + 1);
                        pos = pos + 1;
                    }
                }
            }

        }
        return dp[t.size()];


    }
}

import java.util.*;

import static java.util.Arrays.*;

public class DynamicProgramming {
    public static void main(String[] args) {
        longestValidParentheses("(()");

    }
    public static int longestValidParentheses(String s1) {
        Stack<Integer> s = new Stack<>();
        boolean[] b = new boolean[s1.length()];
        for(int i =0; i < s1.length(); i ++){
            char c = s1.charAt(i);
            if(c=='('){
                s.push(i);
            }
            else {
                if(!s.isEmpty()){
                    b[i]=true;
                    b[s.pop()]=true;
                }
            }

        }
        int count=0;
        int res=0;
        for(int i =0; i < b.length; i ++){
            if(b[i]){
                count++;
            }
            else {
                res = Math.max(count,res);
                count=0;
            }
        }
        return res;
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

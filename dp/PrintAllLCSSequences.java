package dp;

import java.util.ArrayList;
import java.util.List;

public class PrintAllLCSSequences {
    String s, t;

    PrintAllLCSSequences(String s, String t) {
        this.s = s;
        this.t = t;
        System.out.println(all_longest_common_subsequences(s, t));
    }

    private List<String> all_longest_common_subsequences(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();

        solve(list, dp, n, m, new StringBuilder(), s, t);

        return list;
    }

    private void solve(List<String> list, int[][] dp, int n, int m, StringBuilder sb, String s1, String s2) {
        if(n<0 || m<0) {
            list.add(sb.reverse().toString());
            return;
        }

        if(n-1>=0 && m-1>=0 && s1.charAt(n-1) == s2.charAt(m-1)) {
            sb.append(s1.charAt(n-1));
            solve(list, dp, n-1, m-1, sb, s1, s2);
        }

        if(n-1>=0 && m-1>=0 && dp[n-1][m] == dp[n][m-1]) {
            solve(list, dp, n-1, m, new StringBuilder(sb.toString()), s1, s2);
            solve(list, dp, n, m-1, new StringBuilder(sb.toString()), s1, s2);
        }

        if(n-1>=0 && m-1>=0 && dp[n-1][m] > dp[n][m-1]) {
            solve(list, dp, n-1, m, new StringBuilder(sb.toString()), s1, s2);
        } else if(n-1>=0 && m-1>=0 && dp[n][m-1] > dp[n-1][m]) {
            solve(list, dp, n, m-1, new StringBuilder(sb.toString()), s1, s2);
        }


    }
}

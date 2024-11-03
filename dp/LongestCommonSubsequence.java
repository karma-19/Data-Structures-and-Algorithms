package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] dp;
    LongestCommonSubsequence(String str1, String str2, int size1, int size2) {
        dp = new int[size1+1][size2+1];
        System.out.println("LCS Length: " + lcsLength(str1.toCharArray(), str2.toCharArray(), size1, size2));
        System.out.println("LCS String: " + lcsString(str1.toCharArray(), str2.toCharArray(), size1, size2));
        for(int[] arr : dp) System.out.println(Arrays.toString(arr));
    }

    LongestCommonSubsequence(int size1, int size2) {
        dp = new int[size1+1][size2+1];
    }

    public int lcsLength(char[] arr, char[] brr, int n, int m) {
        fillDp(arr, brr, n, m);
        return dp[n][m];
    }

    public String lcsString(char[] arr, char[] brr, int n, int m) {
        fillDp(arr, brr, n, m);

        int i=n, j=m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0) {
            if(arr[i-1]==brr[j-1]) {
                sb.append(arr[i-1]);
                i--; j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }

    private void fillDp(char[] arr, char[] brr, int n, int m) {
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(arr[i-1]==brr[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

}

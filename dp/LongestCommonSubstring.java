package dp;

public class LongestCommonSubstring {
    int[][] dp;
    LongestCommonSubstring(String str1, String str2, int size1, int size2) {
        dp = new int[size1+1][size2+1];
        System.out.println("LCString Length: " + lcsLength(str1.toCharArray(), str2.toCharArray(), size1, size2));
        System.out.println("LCString String: " + lcsString(str1.toCharArray(), str2.toCharArray(), size1, size2));
    }

    private int lcsLength(char[] arr, char[] brr, int n, int m) {
        fillDp(arr, brr, n, m);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private String lcsString(char[] arr, char[] brr, int n, int m) {
        fillDp(arr, brr, n, m);

        int max = Integer.MIN_VALUE;
        int row = 0, col = 0;
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(max < dp[i][j]) {
                    max = dp[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(row>0 && col>0) {
            if(arr[row-1]==brr[col-1]) {
                sb.append(arr[row - 1]);
                row--;
                col--;
            } else {
                break;
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
                    dp[i][j] = 0;
                }
            }
        }
    }
}

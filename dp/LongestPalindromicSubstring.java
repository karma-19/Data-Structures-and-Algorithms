package dp;

public class LongestPalindromicSubstring {

    LongestPalindromicSubstring(String s) {
        System.out.println("Longest Palindromic Sub String length: " + getLength(s));
        System.out.println("Longest Palindromic Sub string: " + longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return lcString(s.toCharArray(), sb.reverse().toString().toCharArray(), s.length());
    }

    private int getLength(String s) {
        StringBuilder sb= new StringBuilder(s);
        return lcLength(s.toCharArray(), sb.reverse().toString().toCharArray(), s.length());
    }

    private int lcLength(char[] arr, char[] brr, int n) {
        return lcString(arr, brr, n).length();
    }

    private String lcString(char[] arr, char[] brr, int n) {
        int[][] dp = new int[n + 1][n + 1];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (arr[i - 1] == brr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        String ans = "";

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (dp[i][j] > max) {
                    String temp = isValid(max, i, j, dp, arr, brr);
                    if (temp != null && temp.length() > max) {

                        max = temp.length();
                        ans = temp;
                    }
                }

            }
        }

        return ans;
    }

    private String isValid(int max, int row, int col, int[][] dp, char[] arr, char[] brr) {
        StringBuilder sb = new StringBuilder();

        while (row > 0 && col > 0) {
            if (arr[row - 1] == brr[col - 1]) {
                sb.append(arr[row - 1]);
            } else {
                break;
            }
            row--;
            col--;
        }

        if (sb.length() > max && sb.toString().equals(sb.reverse().toString())) {
            // System.out.println();
            return sb.toString();
        }
        return null;

    }
}

package dp;

import java.util.ArrayList;
import java.util.List;

public class Dp {
    //print DP array 
    static void printDP(boolean[][] dp) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printDP(int[][] dp) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    //minimum subset sum difference
    static int minimumSubsetDiff(List<Integer> ans, int sum) {
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<ans.size()/2 ; i++) {
            diff = Math.min(diff, sum - 2*ans.get(i));
        }
        return diff;
    }

    //subset sum 
    static int solve(int sum, int[] arr)
    
    {
        int N = arr.length;
        
        boolean[][] dp = new boolean[N+1][sum+1];
        
        for(int i=0; i<N+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        printDP(dp);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<sum+1; i++) {
            if(dp[N][i]) {
                list.add(i);
            }
        }
        System.out.println("MINIMUM Subset sum difference : " + minimumSubsetDiff(list, sum));
        return dp[N][sum]?1:0;
        
    }

    //LCS -> longest common subsequence
    public static void longestCommonSubsequence() {
        String a = "bbabcbcab";
        String b = "bacbcbabb";

        //Recursion : 
        // base condition : len(a) == 0|| len(b)==0 return 0;
        // solve(a, b, n, m) -> if(a[n-1]==b[m-1]) 1 + solve(a, b, n-1, m-1) else Max(solve(a, b, n-1, m)
        //solve(a, b, n,m-1));

        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=0; i<a.length()+1; i++){
            for(int j=0; j<b.length()+1; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }

        System.out.println("longestCommonSubsequence:" + dp[a.length()][b.length()]);
    }

    //longest common sequence of three strings
    static int LCSof3(String A, String B, String C, int n1, int n2, int n3)
    {
        // code here
        if(n1 == 0 || n2 == 0 || n3== 0) {
            return 0;
        }

        if(A.charAt(n1-1) == B.charAt(n2-1) && A.charAt(n1-1) == C.charAt(n3-1)) {
            return 1 + LCSof3(A, B, C, n1-1, n2-1, n3-1);
        }
        return Math.max(LCSof3(A, B, C, n1-1, n2, n3),
                Math.max(LCSof3(A, B, C, n1, n2-1, n3), LCSof3(A, B, C, n1, n2, n3-1)));


    }

    //print longest common subsequence 
    public static void printLongestCommonSubsequence() {
        String a = "abc";
        String b = "cba";
        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=0; i<a.length()+1; i++){
            for(int j=0; j<b.length()+1; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }

        int row = a.length()-1, col = b.length()-1;
        String ans = "";

        while(row >= 0 && col >= 0) {
            if(a.charAt(row)==b.charAt(col)) {
                ans += a.charAt(row);
                row--;
                col--;
            } else {
                if(dp[row-1][col] > dp[row][col-1]) {
                    row--;
                } else {
                    col--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        System.out.println("printLongestCommonSubsequence:" + sb.reverse().toString());
    }

    //LCS -> longest common substring
    public static void longestCommonSubstring() {
        String a = "acbcf";
        String b = "abcdaf";
        int max = 0;

        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=0; i<a.length()+1; i++){
            for(int j=0; j<b.length()+1; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else{
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println("longestCommonSubstring:" + max);
    }

    public static void printLongestCommonSubstring() {
        String a = "acbcf";
        String b = "abcdaf";
        int max = 0;

        int[][] dp = new int[a.length()+1][b.length()+1];

        for(int i=0; i<a.length()+1; i++){
            for(int j=0; j<b.length()+1; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else{
                    dp[i][j] = 0;
                }
            }
        }

        printDP(dp);
    }

    public static void longestPalindromicSubsequence(String s, String rev, int n) {
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0 || j== 0) {
                    dp[i][j] = 0;
                } else if(s.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i=n;
        int j=n;
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int count = 0;
        StringBuilder maxString = new StringBuilder();

        while(i>0 && j>0) {
            if(s.charAt(i-1) == s.charAt(j-1)) {
                sb.append(s.charAt(i-1));
                count++;
                i--;
                j--;
            } else {
                if(max < count) {
                    max = count;
                    maxString = new StringBuilder(sb.toString());
                }
                if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        printDP(dp);

        System.out.println(maxString);
    }

}

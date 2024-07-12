package dp;

import java.util.Arrays;

public class SubsetSum {

    public static int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        //this handles case: if sum==0 and n == 0 than 1 way
        // if sum == 0 and n>0, case 1: arr[i] ==0 then 2 way, case 2: arr[i]!=0 then 1 way
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;

        for(int i=1; i<=sum; i++) {
            dp[0][i]= 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=0; j<sum+1; j++) {

                if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        for(int[] temp : dp) System.out.println(Arrays.toString(temp));

        return dp[n][sum];
    }

    public int adityaVermaSubsetSum(int[] arr, int n, int sum) {
        //aditya verma

        //works if arr doesn't contain '0' element
        int[][] dp = new int[n+1][sum+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<sum+1; j++) {
                if(j==0) {
                    dp[i][j] = 1;
                } else if(i==0) {
                    dp[i][j] = 0;
                }else {
                    if(arr[i-1] <= j) {
                        dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }
}

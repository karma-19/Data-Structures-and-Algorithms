package dp;

import static dp.Dp.*;
import static dp.Knapsack.knapsack;

public class Main {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdef";
        String s3 = "ghcdba";
        // int[] arr = new int[] {1, 6, 11, 5};
        // int sum = 0;
        // for(int i=0; i< arr.length ;i++) sum+= arr[i];
//         System.out.println(solve(sum, arr) );

        //longest sub sequence
//          longestCommonSubsequence();
        System.out.println(LCSof3(s1, s2, s3, s1.length(), s2.length(), s3.length()));
//          printLongestCommonSubsequence();

        // //longest sub String
//         longestCommonSubstring();
//         printLongestCommonSubstring();

//        longestPalindromicSubsequence("abcd", "dcba", 4);


        //Knapsack
        int [] arr = new int[]{2, 5, 3, 6};
        int sum = 4;
        System.out.println(knapsack(arr, 0, arr.length-1, sum));
        System.out.println(knapsack(arr, arr.length, sum));
    }
}

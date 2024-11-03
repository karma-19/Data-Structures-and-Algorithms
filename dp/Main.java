package dp;

import static dp.Dp.*;
import static dp.Knapsack.knapsack;

public class Main {
    public static void main(String[] args) {
        String str1 = "babgbag";
        String str2 = "bag";

        new LongestCommonSubsequence(str1, str2, str1.length(), str2.length());
//        new LongestCommonSubstring(str1, str2, str1.length(), str2.length());
//        new ShortestCommonSupersequence(str1, str2, str1.length(), str2.length());

//        new LongestPalindromicSubstring(str1);
//        new LongestPalindromicSubsequence(str1, str1.length());
//        new PrintAllLCSSequences(str1, str2);


    }
}

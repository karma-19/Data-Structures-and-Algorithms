package dp;

public class LongestPalindromicSubsequence {
    LongestPalindromicSubsequence(String str1, int size1) {
        StringBuilder sb = new StringBuilder(str1);
        String str2 = sb.reverse().toString();

        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence(size1, size1);

        System.out.println("LPS Length: " + longestCommonSubsequence.lcsLength(str1.toCharArray(), str2.toCharArray(), size1, size1));
        System.out.println("LPS String: " + longestCommonSubsequence.lcsString(str1.toCharArray(), str2.toCharArray(), size1, size1));
    }
}

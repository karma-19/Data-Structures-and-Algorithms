package string;

public class KmpAlgo {
    //find if str contains pattern in O(N) time complexity. Constraint: str and pattern length up to 10^5.
    //contains ato z;
    //watch kmp from abdul bari
    public static void main(String[] args) {
        String str = "ababcabcabababd";
        String pattern = "ababd";

        int n = str.length(), m = pattern.length();

        int[] longestPrefix = getLPS(pattern, m);
    }

    private static int[] getLPS(String pattern, int n) {
        int[] lps = new int[n+1];

    }
}

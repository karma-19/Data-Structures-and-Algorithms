package algorithms;

import java.util.Arrays;

public class Fibonacci {
    private static int mod = (int)(1e9 + 7);

    public static void main(String[] args) {
        System.out.println(solve(10));
    }

    public static int solve(int A) {

        if(A <= 2) return 1;

        long[][] mat = new long[2][2];
        mat[0][0] = 1;
        mat[0][1] = 1;
        mat[1][0] = 1;
        mat[1][1] = 0;

        long[][] res = power(mat, A);
        for(long[] temp : res)
        System.out.println(Arrays.toString(temp));

        return (int)res[1][0];
    }

    private static long[][] power(long[][] mat, int n) {
        if(n==1) return mat;

        long[][] temp = power(mat, n/2);

        if(n%2==0) {
            return multiply(temp, temp);
        }

        return multiply(temp, multiply(temp, mat));
    }

    private static long[][] multiply(long[][] mat1, long[][] mat2) {
        long[][] ans = new long[2][2];
        for(int i=0; i<2; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) {
                    ans[i][j] += mat1[i][k] * mat2[k][j] % mod;
                }
            }
        }

        return ans;
    }
}

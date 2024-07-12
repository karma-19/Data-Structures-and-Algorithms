package dp;

public class Knapsack {

    public static int knapsack(int[] arr, int beg, int end, int sum) {
        if(sum == 0 || (end - beg) == 0) {
            return 0;
        }

        if(arr[end] > sum) {
            return knapsack(arr, beg, end-1, sum);
        } else {
            return Math.max(arr[end] + knapsack(arr, beg, end, sum-arr[end]),
                    knapsack(arr, beg, end-1, sum));
        }
    }

    public static long knapsack(int[] arr, int N, int sum) {
        if(sum==0) return 1;
        if(N <= 0 || sum < 0) return 0;


        return knapsack(arr, N, sum-arr[N-1]) +
                knapsack(arr, N-1, sum);

    }
}

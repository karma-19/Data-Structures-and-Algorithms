package matrix;

public class Matrix {
    public static void main(String[] args) {
        int arr[][] = {{ 1, 2, -1, -4, -20 },
        { -8, -3, 4, 2, 1 }, 
        { 3, 8, 6, 1, 3 },
        { -4, -1, 1, 7, -6 },
        { 0, -4, 10, -5, 1 }};

        // rotateBy90(arr);
        solve(arr);
    }

    public static void solve(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                for(int k=arr.length-1; k>i; k--) {
                    for(int l=arr[0].length-1; l>j; l--) {
                        max = Math.max(max, arr[k][l]-arr[i][j]);
                    }
                }
            }
        }
        System.out.println(max);

        //optimized

        //put max element on last row and coli
        int maxValue = arr[arr.length-1][arr.length-1];
        for(int i=arr.length-1; i>=0; i--) {
            maxValue = Math.max(maxValue, arr[arr.length-1][i]);
            arr[arr.length-1][i] = maxValue;
        }

        maxValue = arr[arr.length-1][arr.length-1];
        for(int i=arr[0].length-1; i>=0; i--) {
            maxValue = Math.max(maxValue, arr[i][arr.length-1]);
            arr[i][arr.length-1] = maxValue;
        }

        int N = arr.length;

//        for(int i=N-2; i>=0; i--) {
//            for(int j=N-2; j>=0; j--) {
//                if(arr[i+1][j+1] - arr[i][j] > )
//            }
//        }

    }

    public static void rotateBy90(int[][] arr) {
        //with extra space
        int[][] ans = new int[arr.length][arr[0].length];

        int x = 0, y= 0;
        for(int j=0; j<arr[0].length; j++) {
            for(int i=arr.length-1; i>=0; i--) {
                ans[x][y++] = arr[i][j];
            }
            x++;
            y=0;
        }

        //without extra space
        // https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
    }
}

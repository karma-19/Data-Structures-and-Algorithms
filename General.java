import java.util.*;

public class General {
    public static int[] generateArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = random.nextInt(size);
        }
        System.out.println("Original Array: " + Arrays.toString(arr));
        return arr;
    }

    public static Set<Integer> generateArrayWithDistinct(int size) {
        int[] arr = generateArray(size);
        Set<Integer> set = new HashSet<>();
        System.out.println("Distinct Array: " + set);
        return set;
    }

    public static void print2D(int[][] arr) {
        for(int i=0;i <arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

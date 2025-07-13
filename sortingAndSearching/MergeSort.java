package sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 3, 4};

        mergeSortt(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    private static void mergeSortt(int[] arr, int beg, int end) {
        if(beg < end) {
            int mid = beg + (end - beg)/2;
            mergeSortt(arr, beg, mid);
            mergeSortt(arr, mid+1, end);
            merge(arr, beg, mid , end);
        }
    }

    private static void merge(int[] arr, int beg, int mid, int end) {
        int i = beg, j = mid+1;
        int[] temp = new int[end-beg+1];
        int index = 0;

        while(i<=mid && j<=end) {
            if(arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[index++] = arr[i++];
        }

        while(j <= end) {
            temp[index++] = arr[j++];
        }

        for(int x=0; x<temp.length; x++) {
            arr[beg + x] = temp[x];
        }
    }
}

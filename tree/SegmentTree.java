package tree;

import java.util.Scanner;

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }

    private void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(2 * node + 1, start, mid, idx, value);
            } else {
                update(2 * node + 2, mid + 1, end, idx, value);
            }
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return Integer.MIN_VALUE; // Return a value that won't affect the max
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftMax = query(2 * node + 1, start, mid, l, r);
        int rightMax = query(2 * node + 2, mid + 1, end, l, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

/*
5
1 3 2 7 9
3
QUERY 1 4
UPDATE 2 10
QUERY 2 3
 */

        // Input array size
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create segment tree
        SegmentTree segmentTree = new SegmentTree(arr);

        // Input number of queries
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String operation = scanner.next();
            if (operation.equals("QUERY")) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                // Perform query
                System.out.println(segmentTree.query(l, r));
            } else if (operation.equals("UPDATE")) {
                int idx = scanner.nextInt();
                int value = scanner.nextInt();
                // Perform update
                segmentTree.update(idx, value);
            }
        }

        scanner.close();
    }
}

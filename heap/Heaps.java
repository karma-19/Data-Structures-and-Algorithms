package heap;//{ Driver Code Starts
//Initial Template for Java

class KthSmallestElement{
	public static void main(String[] args){
		int[][] mat = new int[][] {{16, 28, 60, 64},
        {22, 41, 63, 91},
        {27, 50, 87, 93},
        {36, 78, 87, 94 }};
        int k = 12;

        System.out.println(Heaps.kthSmallest(mat, 4, k));
	}
}

// } Driver Code Ends


//User function Template for Java


class Heaps
{
    static class Heap {
        int val; 
        int i; 
        int j;
        public Heap(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
    
    static void minHeapify(Heap[] arr, int i, int n) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int min = i;
        
        if(left < n && arr[left].val < arr[min].val) {
            min = left;
        } 
        
        if(right < n && arr[right].val < arr[min].val) {
            min = right;
        }
        
        if(min != i) {
            swap(i, min, arr);
            minHeapify(arr, min, n);
        }
        
    }
    
    static void swap(int i, int j, Heap[] arr) {
        Heap temp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = temp;
    }
    
    static void buildHeap(Heap[] arr, int n) {
        int mid = (n-1)/2;
        
        for(int i=mid; i>=0; i--) {
            minHeapify(arr, i, n);
        }
    }
    
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        if(k <= 0 || n * n < k) {
            return Integer.MAX_VALUE;
        }
        
        Heap[] harr = new Heap[n];
        
        for(int i=0; i<n; i++) {
            harr[i] = new Heap(mat[0][i], 0, i);
        }
        
        buildHeap(harr, n);
        
        Heap hr = new Heap(0, 0, 0);
        for(int i=0; i<k; i++) {
            hr = harr[0];
            
            int nextVal = hr.i < n-1 ? mat[hr.i + 1][hr.j] : Integer.MAX_VALUE;
            
            harr[0] = new Heap(nextVal, hr.i + 1, hr.j);
            
            minHeapify(harr, 0, n);
        }
        return hr.val;
    }
}
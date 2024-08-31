
//Here Max Heap is Created

//Time complexity:
//BEST : O(N log(N))
//AVG : O(N log(N))
//WORST : O(N log(N))
//Space Complexity: O(1)

// Heap is Actual array but represented as a Complete Binary Tree
// There Are N/2 Leaf Node Nodes In Complete Binary Tree But IF We Consider 0 indexed Array Then There are N/2 - 1 Leaf Nodes are present there. 

// Approach : So firstly We Have to Build Heap We iterate loop from N/2 - 1 to first element of given array and call heapify function for that.
// Heapify is nothing but downHeap Function Which Check if any of it child is greter than parent then it will Swap that two element.
// after building maxheap the max element will be at root(0th index) So, we will remove it from the heap and put it in sorted part in array.
// to do this following procedure we have to make sure that heap must be kept as MaxHeap so we have to call heapify function for every iteration. 

public class HeapSort {
    public void sort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    int max(int a, int b, int c){
        int t = Math.max(a, b);
        return Math.max(t, c);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver's code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        // Function call
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}


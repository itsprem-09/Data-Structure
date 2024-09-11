
// Efficient for Array which is already sorted or nearly sorted
// Inefficient for larger input
// Stable Algorithm and Inplace Algorithm.
// N-1 Passes
// incremental algorithm
// best sorting algo for array having length less than 100 element
// On average (k + 1) / 2 comparisons are required to place the kth element into its correct position.

// Best case occures at Array which is already sorted

//Time complexity:
//BEST : O(N)
//AVG : O(N2)
//WORST : O(N2)
//Space Complexity: O(1)

//Approach : Devide the Array into unsorted and sorted portion
//           initally sorted array is first element
//           Select an element in each iteration from the unsorted array(using a loop).
//           Place it in its corresponding position in the sorted part and shift the remaining elements accordingly (using an inner loop and swapping).


public class InsertionSort {
    static void insertion_sort(int[] arr, int n) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        System.out.println("After insertion sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSortPPT(int[] arr){
        int i = 1;
        int n = arr.length;
        while (i < n) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key) {    
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            i++;
        }
    }

    public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using insertion Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insertion_sort(arr, n);
    }

}  

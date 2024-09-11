
// Highly efficient Sorting Algorithm
// Partitioning an array of data into smaller array.
// Divide and conquer algorithm
// Efficient for larger Dataset 
// Not Stable Sort

//Pivot Element : Which Element in Array where left Side of Element is lesser than and right side of element is greater than it. initally we declare first element as pivot element

//Time complexity:
//BEST : O(N log(N))
//AVG : O(N log(N))
//WORST : O(N2)
//Space Complexity: O(1) + O(N) auxiliary stack space.

// Worst Case – This case occurs when the pivot is the greatest or smallest element of the array. If the partition is done and the last element is the pivot, then the worst case would be either in the increasing order of the array or in the decreasing order of the array.

//Approach : Pick a pivot and place it in its correct place in the sorted array.
//           Shift smaller elements(i.e. Smaller than the pivot) on the left of the pivot and larger ones to the right.

public class QuickSort {
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    public static int[] quickSort(int[] arr) {
        // Write your code here.
        qs(arr, 0, arr.length - 1);
        return arr;
    }
}

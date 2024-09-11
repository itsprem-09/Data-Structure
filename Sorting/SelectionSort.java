
// InPlace Algorithm
// Not Stable
// Not Sutable for large data set
// Used for Smallar input
// Devide an array into two parts : Sorted and Unsorted.
// N-1 Passes

//Time complexity:
//BEST : O(N2)
//AVG : O(N2)
//WORST : O(N2)
//Space Complexity: O(1)

//Approach : Find Minimum Element's index and swap that element with current Element
//           (Push the minimum element from array at first)

public class SelectionSort {
    static void selection_sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            //swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        selection_sort(arr, n);
    }
}
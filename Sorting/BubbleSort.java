// Stable Sorting Algorithm
// Inplace Algorithm
// Slower For Large Dataset
// Method called bubble up.
// Maximum N-1 Pass needed to sort an array.
// Used when input is already sorted.
// N Passes(Not Sorted Array)
// 1 Pass(Sorted Array)

// Best Case Occurs At Array which is Already Sorted.

//Time complexity:
//BEST : O(N)
//AVG : O(N2)
//WORST : O(N2)
//Space Complexity: O(1)

//Approach : push the maximum element to the last index of the selected range, by repeatedly swapping adjacent elements.

public class BubbleSort {
    static void bubble_sort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("After bubble sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubble_sort(arr, n);
    }

}

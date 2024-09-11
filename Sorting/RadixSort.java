// Combined With CountSort
// Stable Sorting Algorithm
// Radix sort is a Non-comparative sorting algorithm that is better than the comparative sorting algorithms. It has linear time complexity that is better than the comparative algorithms with complexity O(n logn).

//Time complexity:
//BEST : O(N * k) k = Number Of Digits in Largest Number
//AVG : O(N * k)
//WORST : O(N * k)
//Space Complexity: O(N + k) k = the range of the input

//Approach : Get the max Element from array iterate a for loop starting from exponent 1 to till max/exp > 0 and call countSort function in each iteration.
//Example : if max digit is 421 then loop should iterate for 3 times for every exponent(bins , tens , hundreds).
// In countSort function declare an array of size 10 and retrive perticluar exponent's digit from that number with given formula : (arr[i]/exp)%10. and increase that digit count in array. 
// After that add each element with its previous element to retrive exact(correct) position of each element.
// at last itrate loop from last element find the index of it and decrease count of that element in count array.

public class RadixSort {
    
    // A utility function to get maximum value in arr[]
    public static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public static void countSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n]; // output array
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    public static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits

        int max = getMax(arr, n);
        // int max = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // A utility function to print an array
    public static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Main driver method
    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        // Function Call
        radixsort(arr, n);
        print(arr, n);
    }
}


import java.util.Arrays;

// It is Optimization of Interstion Sort
// When gap will became 1 it will run the insertion sort. 
// heap sort surpasses shell sort in efficiency as we approach 2000 elements to be sorted

//Time complexity:
//BEST : O(N * log(N))
//AVG : O(N * log(N)) (PPT - O(N2))
//WORST : O(N2 * log(N))
//Space Complexity: O(1)

// Approach : Initally declare a gap of n/2 where n is size of an array. and run that loop till gap became 1.
// After that check element that which has index difference = gap
// and swap them if it is bigger than it.(Smaller element should come earlier)

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2 , 4 , 1 , 9 , -1 , 3 , 0 , 1};
        shellSortPPT(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
    }

    public static void shellSortPPT(int[] arr){
        int n = arr.length;
        for (int gap = n/2; gap >= 1; gap/=2) {
            for (int j = gap; j < n; j++) {
                for (int i = j - gap; i >= 0; i-=gap) {
                    if (arr[i + gap] > arr[i]) {
                        break;
                    }
                    int t = arr[i + gap];
                    arr[i + gap] = arr[i];
                    arr[i] = t;
                }
            }
        }
    }
}

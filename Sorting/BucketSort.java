import java.util.ArrayList;
import java.util.List;

// Involves dividing element into various groups or buckets.
// Formed by uniformly distributing element
// Floting Points
// Used when input is distributed uniformly over range

// Combined With Insertion Sort.
// Used For Sorting Floting Point Numbers In Range Of [0,1] OR When input is distributed uniformly over a range.
// Scatter-gather approach
// Non-Comparison based Algorithm.
// It is a distribution sort.

//Time complexity:
//BEST : O(N + k) k = Number Of Buckets 
//AVG : O(N + k)
//WORST : O(N2)
//Space Complexity: O(N + k) OR O(N * k) (Not Sure)

//Approach : Get an Array and Create Number of Buckets Length of An Array. Get an element from an array multiply it with length of an array and put it into that bucket. After that sort the each bucket and retrive elements from every element one by one. 

public class BucketSort {
    // Insertion sort function to sort individual buckets
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    // Function to sort arr[] of size n using bucket sort
    @SuppressWarnings("unchecked")
    public static void bucketSort(float[] arr) {
        int n = arr.length;

        // 1) Create n empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        // 3) Sort individual buckets using insertion sort
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        bucketSort(arr);

        System.out.println("Sorted array is:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}


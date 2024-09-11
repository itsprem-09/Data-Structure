
// Stable Algorithm
// Comparision Based Algorithm.
// Not an inplace algorithm

//Time complexity:
//BEST : O(N log(N))
//AVG : O(N log(N))
//WORST : O(N log(N))
//Space Complexity: O(N) + O(N) auxiliary stack space.

// divide and conquers algorithm

//Approach : Devide the array into two parts and arrange them in sorted way

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,1,-5,2,3,0,9,23,-1,7491};
        mergeSort(arr, 0, arr.length-1);
        
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr,int low,int high){
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }

    public static void merge(int[] arr,int low,int mid,int high){
        int leftPointer = low;
        int rightPointer = mid+1;
        int[] temp = new int[arr.length];
        
        int tempIterator = low;

        while (leftPointer <= mid && rightPointer <= high) {
            if (arr[leftPointer] <= arr[rightPointer]) {
                temp[tempIterator] = arr[leftPointer];
                leftPointer++;
            }
            else{
                temp[tempIterator] = arr[rightPointer];
                rightPointer++;
            }
            tempIterator++;
        }

        //check if any element left in left or right seperated array
        if (leftPointer > mid) {
            for (int i = rightPointer; i <= high; i++) {
                temp[tempIterator] = arr[i];
                tempIterator++;
            }
        }
        else{
            for (int i = leftPointer; i <= mid; i++) {
                temp[tempIterator] = arr[i];
                tempIterator++;
            }
        }

        //replace orignal array to sorted one
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }
}

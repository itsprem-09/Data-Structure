
import java.util.*;

// Stable Sorting Algorithm

//Time complexity:
//BEST : O(N + k) k = Largest Element In Array 
//AVG : O(N + k)
//WORST : O(N + k)
//Space Complexity: O(k)

//Approach : Find MAX element in array and make new array named freqCount with size of max+1 and count freq of every element in given array and store it in freqCount. After that iterate a loop from 0 to max element and check if i from freqCount > 0 then replace orignal array with i. 

public class CountSort {

    public static void countSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }

        int[] countArray = new int[max + 1];

        for (int num : array) {
            countArray[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                array[index] = i;
                index++;
                countArray[i]--;
            }
        }

    }

  public static void countSortPPT(int[] arr){
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
    }

    //it will be position array afterward
    int[] freqCount = new int[max + 1];

    for (int i = 0; i < arr.length; i++) {
        freqCount[arr[i]]++;
    }

    for (int i = 1; i < freqCount.length; i++) {
        freqCount[i] += freqCount[i-1];
    }

    int[] ans = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
        freqCount[arr[i]]--;
        ans[freqCount[arr[i]]] = arr[i];
    }

    //replace orignal array
    for (int i = 0; i < ans.length; i++) {
        arr[i] = ans[i];
    }
  }

    public static void countSortHash(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int i = min; i <= max; i++) {
            int count = countMap.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                arr[index] = i;
                index++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 10, 9, 2, 4, 9, 7 };
        countSortPPT(arr);
        System.out.println(Arrays.toString(arr));
    }
}
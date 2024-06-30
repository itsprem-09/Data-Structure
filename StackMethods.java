

public class StackMethods {
    
    public static int top = -1;

    public static void push(int[] arr, int val){
        if (top >= arr.length) {
            System.out.println("Stack Overflow....");
            return;
        }
        else{
            top++;
            arr[top] = val;
        }
    }
    public static int pop(int[] arr){
        if (top < 0) {
            System.out.println("Stack Underflow....");
            return 0;
        }
        else{
            top--;
            return arr[top+1];
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        push(arr, 5);
        push(arr, 6);
        push(arr, 7);
        System.out.println(pop(arr));
    }
}

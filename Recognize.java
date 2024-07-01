
import java.util.Scanner;

class StackDemo{
    char[] str;
    int size;
    int top;

    public StackDemo(int size){
        this.size = size;
        str = new char[size];
        top = 0;
    }

    public void push(char value) {
        if (top >= size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        str[top] = value;
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        top--;
        return str[top + 1];
    }

    public char nextChar()

}

public class Recognize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = sc.next();
        
        StackDemo s = new StackDemo(str.length());
        s.push('c');

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'c') {
                s.push(str.charAt(i));    
            }
            i++;
            if (str.charAt(i) != s.pop()) {
                System.out.println("Invalid String ");
            }
            else{
                s
            }
        }

    }
}

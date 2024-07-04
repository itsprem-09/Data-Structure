


class Node {

    int data;
    Node next;


    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class LL {

    Node head = null;

    public Node addAtFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode; 
        return head;
    }

    public void display() {
        Node move = head;
        while (move != null) {
            System.out.println(move.data + " ");
            move = move.next;
        }
    }

    public Node insertAtEnd(int data){
        Node newNode = new Node(data);
        Node move = head;

        if (head == null) {
            return newNode;
        }

        while (move.next != null) { 
            move = move.next;
        }
        move.next = newNode;
        return head;
    }

    public Node deleteFirst(){
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public Node deleteLast(){
        if (head == null || head.next == null) {
            return null;
        }
        Node move = head;
        while (move.next.next != null) { 
            move = move.next;
        }
        move.next = null;
        return head;
    }

    public Node deleteAtPosition(int position){
        if (head == null || position == 1 || position == 0 ) {
            return null;
        }
        Node prev = head;
        int count = 1;
        while (count != position-1) {
            prev = prev.next;
            count++;
        }
        prev.next = prev.next.next;
        return head;
    }

    
}



public class LinkedListDemo{
    public static void main(String[] args) {
        Node n = new Node(5);
        System.out.println(n.data);

        System.out.println("Enter Function You want to Select : ");
        System.out.println("1. Insert a node at the front of the linked list : ");
        System.out.println("2. Display all nodes : ");
        System.out.println("3. Delete a first node of the linked list");
        System.out.println("4. Insert a node at the end of the linked list");
        System.out.println("5. Delete a last node of the linked list");
        System.out.println("6. Delete a node from specified position");
        System.out.println("7. Exit");
    }
}
import java.util.Scanner;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printMiddle() {
        Node slower = head;
        Node faster = head;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        System.out.println("mid " + slower.data);
    }

    public void push(int dummy_new) {
        Node new_node = new Node(dummy_new);
        new_node.next = head;
        head = new_node;
    }

    public void Print() {
        Node temp_Node = head;
        while (temp_Node != null) {
            System.out.print(temp_Node.data + "-");
            temp_Node = temp_Node.next;
        }
        System.out.println("X");
    }

    public static void main(String[] args) {
        LinkedList mylist = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter linkedlist -1 for stop");
        int test;
        while ((test = sc.nextInt()) != -1) {
            mylist.push(test);
        }
        sc.close();
        mylist.Print();
        mylist.printMiddle();
    }
}

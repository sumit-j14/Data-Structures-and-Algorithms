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

    void nthfromlast(int n) {
        Node Captain_Node = head;
        Node temp_Node = head;
        int counter = 0;
        if (head != null) {
            while (counter < n) {
                if (temp_Node == null) {
                    System.out.println("n is greater than length itself");
                    return;
                }
                temp_Node = temp_Node.next;
                counter++;
            }
            if (temp_Node == null) {
                if (head != null)
                    System.out.println("answer is " + head.data);
            } else {
                while (temp_Node != null) {
                    Captain_Node = Captain_Node.next;
                    temp_Node = temp_Node.next;
                }
                System.out.println("answer is " + Captain_Node.data);
            }
        }
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
        mylist.Print();
        System.out.println("enter value of n");
        int position = sc.nextInt();
        mylist.nthfromlast(position);
        sc.close();
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void TakeGraphInput(ArrayList<ArrayList<Integer>> graph) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
            System.out.println("Enter number of vertices connected to " + i);
            int adj = sc.nextInt();

            System.out.println("Enter adjacent vertices");
            for (int j = 0; j < adj; j++) {
                graph.get(i).add(sc.nextInt());
            }
        }
        sc.close();
    }

    public static void PrintGraph(ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void BFSTraversal(ArrayList<ArrayList<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() != 0) {
            int i = queue.poll();
            if (visited.contains(i) != true) {
                System.out.println(i);
                visited.add(i);
                for (int j = 0; j < graph.get(i).size(); j++) {
                    if (visited.contains(graph.get(i).get(j)) != true) {
                        queue.add(graph.get(i).get(j));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        TakeGraphInput(graph);
        PrintGraph(graph);
        BFSTraversal(graph);
    }

}

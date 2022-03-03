import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;

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

    public static void DFSTraversal(ArrayList<ArrayList<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        DFSHelp(graph, 0, visited);
    }

    public static void DFSHelp(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited) {
        visited.add(start);
        System.out.println(start);
        for (int i : graph.get(start)) {
            if (visited.contains(i) != true) {
                DFSHelp(graph, i, visited);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        TakeGraphInput(graph);
        PrintGraph(graph);
        DFSTraversal(graph);
    }
}

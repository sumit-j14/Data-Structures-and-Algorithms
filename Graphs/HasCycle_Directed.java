//makes use of DFS Approach
//this works for directed graph
//uses 2 HashSets to store results
import java.util.ArrayList;
import java.util.HashMap;
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

    public static boolean CycleHelp(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited,
            HashSet<Integer> recursionStack) {
        visited.add(start);
        recursionStack.add(start);
        for (int i : graph.get(start)) {
            if (visited.contains(i) == false) {
                if (CycleHelp(graph, i, visited, recursionStack) == true)
                    return true;
            } else if (recursionStack.contains(i))
                return true;
        }
        recursionStack.remove(start);
        return false;
    }

    public static boolean HasCycle(ArrayList<ArrayList<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> recursionStack = new HashSet<>();
        for (int i = 0; i < graph.size(); i++) {
            if (visited.contains(i) == false) {
                if (CycleHelp(graph, i, visited, recursionStack) == true)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        TakeGraphInput(graph);
        PrintGraph(graph);
        System.out.println(HasCycle(graph));
    }
}

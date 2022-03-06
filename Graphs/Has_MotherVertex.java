import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Mother_Vertex {
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

	public static void pseudo_DFS(ArrayList<ArrayList<Integer>> graph, int start, HashSet<Integer> visited,
			HashSet<Integer> TestSet) {
		for (int i : graph.get(start)) {
			visited.add(i);
			TestSet.add(i);
			pseudo_DFS(graph, i, visited, TestSet);
		}
	}

	public static boolean Has_Mother_Vertex(ArrayList<ArrayList<Integer>> graph) {
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 0; i < graph.size(); i++) {

			if (visited.contains(i) != true) {
				visited.add(i);
				HashSet<Integer> testSet = new HashSet<>();
				testSet.add(i);
				pseudo_DFS(graph, i, visited, testSet);
				if (testSet.size() == graph.size()) {
					System.out.println("Found mother vertex " + i);
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		TakeGraphInput(graph);
		PrintGraph(graph);
		boolean answer = Has_Mother_Vertex(graph);
		System.out.println(answer);
	}

}

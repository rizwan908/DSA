package pattern.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

	public static List<Integer> sort(int numVertices, int[][] edges) {

		List<Integer> result = new ArrayList<>();

		HashMap<Integer, Integer> inDegree = new HashMap<>();
		HashMap<Integer, List<Integer>> adjList = new HashMap<>();

		for (int i = 0; i < numVertices; i++) {
			inDegree.put(i, 0);
			adjList.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < numVertices; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];

			adjList.get(parent).add(child);

			inDegree.put(child, inDegree.get(child) + 1);
		}

		Queue<Integer> queue = new LinkedList<>();

		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.add(entry.getKey());
			}
		}

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			result.add(vertex);

			List<Integer> children = adjList.get(vertex);

			for (int child : children) {
				inDegree.put(child, inDegree.get(child) - 1);

				if (inDegree.get(child) == 0)
					queue.add(child);
			}
		}

		if (result.size() != numVertices) {
			return new ArrayList<Integer>();
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 }, new int[] { 2, 1 },
				new int[] { 3, 1 } });
		System.out.println(result);

		result = sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 }, new int[] { 5, 4 },
				new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}

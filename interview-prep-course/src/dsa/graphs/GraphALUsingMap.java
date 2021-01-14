package dsa.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphALUsingMap<T> {

	private Map<T, LinkedList<T>> nodes = new HashMap<>();

	public void addNode(T node) {
		if (!nodes.containsKey(node))
			nodes.put(node, new LinkedList<T>());
	}

	public void addEdge(T source, T destination, boolean biDirectional) {
		addNode(source);
		addNode(destination);

		nodes.get(source).add(destination);
		if (biDirectional)
			nodes.get(destination).add(source);
	}

	/**
	 * find if two nodes are connected or check if an edge exist
	 * 
	 * @return
	 */
	public boolean areConneted(T node1, T node2) {
		if (nodes.containsKey(node1) && nodes.containsKey(node2))
			return nodes.get(node1).contains(node2);
		return false;
	}

	/**
	 * 
	 * find adjacent nodes to the given node
	 * 
	 * @param node
	 * @return
	 */
	public List<T> findAdjacentNodes(T node) {
		if (!nodes.containsKey(node))
			return null;

		return nodes.get(node);
	}

	public boolean hasNode(T node) {
		return nodes.containsKey(node);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

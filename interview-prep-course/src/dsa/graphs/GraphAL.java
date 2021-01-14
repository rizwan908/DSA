package dsa.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Graph implementation using adjacency list
 *
 * @param <T>
 */
public class GraphAL<T> {

	private LinkedList<T> nodes = new LinkedList<T>();
	private List<LinkedList<Integer>> edges = new LinkedList<>();

	public void insertNode(T node) {
		nodes.add(node);
		edges.add(nodes.indexOf(node), new LinkedList<Integer>());
	}

	public void insertEdge(T source, T dest, boolean biDirectional) {
		// if source or dest node doesn't exist

		if (!nodes.contains(source) || !nodes.contains(dest))
			throw new NoSuchElementException();

		// find index of source and dest in nodes list

		int sourceIndex = 0;
		int destIndex = 0;

		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(source))
				sourceIndex = i;
			else if (nodes.get(i).equals(dest))
				destIndex = i;
		}

		// now put dest index in the list at the source index in edges list

		edges.get(sourceIndex).add(destIndex);

		if (biDirectional)
			edges.get(destIndex).add(sourceIndex);
	}

	/**
	 * find if two nodes are connected or check if an edge exist
	 * 
	 * @return
	 */
	public boolean areConneted(T node1, T node2) {
		if (edges.get(nodes.indexOf(node1)).contains(node2))
			return true;

		return false;
	}

	/**
	 * 
	 * find adjacent nodes to the given node
	 * 
	 * @param node
	 * @return
	 */
	public List<Integer> findAdjacentNodes(T node) {

		if (!nodes.contains(node))
			return null;

		return edges.get(nodes.indexOf(node));
	}

	public boolean hasNode(T node) {
		return nodes.contains(node);
	}

}

package dsa.stacks;

import java.util.NoSuchElementException;

public class QueueCCI<T> {

	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	/**
	 * make current as last and if its first element that first==last;
	 * 
	 * @param data
	 */
	public void add(T data) {
		QueueNode<T> current = new QueueNode<T>(data);

		if (last != null)
			last.next = current;

		last = current;

		if (first == null)
			first = last;
	}

	public T remove() {
		if (first == null)
			throw new NoSuchElementException();

		T data = first.data;
		first = first.next;
		if (first == null)
			last = null;

		return data;
	}

	public T peek() {
		if (first == null)
			throw new NoSuchElementException();

		return first.data;

	}

	public boolean isEmpty() {
		return first == null;
	}
}

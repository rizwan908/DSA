package dsa.stacks;

import java.util.EmptyStackException;

public class StackCCI<T> {

	public static class StackNode<T> {

		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	/**
	 * link top to current next and make current as top.
	 * 
	 * @param data
	 */
	public void push(T data) {
		StackNode<T> current = new StackNode<T>(data);

		current.next = top;
		top = current;
	}

	/**
	 * get the item to be returned and change top reference
	 * 
	 * @return item to be removed
	 */
	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		return item;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

}

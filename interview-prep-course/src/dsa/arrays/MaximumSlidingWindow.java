package dsa.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Find Maximum in Sliding Window:
 * 
 * Given a large array of integers and a window of size w, find the current
 * maximum value in the window as the window slides through the entire array.
 * Pick all the max values from each window and return them
 *
 */
public class MaximumSlidingWindow {

	/**
	 * 
	 * brute force approach
	 * 
	 * @param arr array under consideration
	 * @param w   window size
	 * @return array containing max element of each window
	 */
	public static List<Integer> maxSlidingWindowBF(int[] arr, int w) {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length - 2; i++) {
			int max = arr[i];
			for (int j = i + 1; j < i + w; j++) {
				max = max > arr[j] ? max : arr[j];

			}
			list.add(max);
		}

		return list;
	}

	public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {

		ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
		Deque<Integer> list = new LinkedList<Integer>(); // creating a linked list

		if (arr.length > 0) {

			if (arr.length < windowSize) // Invalid State
				return result;

			for (int i = 0; i < windowSize; ++i) {
				// Removing last smallest element index
				while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
					list.removeLast();
				}

				// Adding newly picked element index
				list.addLast(i);
			}

			for (int i = windowSize; i < arr.length; ++i) {
				result.add(arr[list.peek()]);

				// Removing all the elements indexes which are not in the current window
				while ((!list.isEmpty()) && list.peek() <= i - windowSize)
					list.removeFirst();

				// Removing the smaller elements indexes which are not required
				while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
					list.removeLast();

				// Adding newly picked element index
				list.addLast(i);
			}

			// Adding the max number of the current window in the result
			result.add(arr[list.peek()]);
			return result; // returning result
		} else
			return result;
	}

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("Array = " + Arrays.toString(array));
		System.out.println("Max = " + maxSlidingWindowBF(array, 3));

		int[] array2 = { 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67 };
		System.out.println("Array = " + Arrays.toString(array2));
		System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
	}

}

package pattern.topKelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KLargestNumbers {

	/**
	 * Problem Statement # Given an unsorted array of numbers, find the ‘K’ largest
	 * numbers in it.
	 * 
	 * Note: For a detailed discussion about different approaches to solve this
	 * problem, take a look at Kth Smallest Number.
	 * 
	 * Time complexity # As discussed above, the time complexity of this algorithm
	 * is O(K*logK+(N-K)*logK), which is asymptotically equal to O(N*logK)
	 * 
	 * Space complexity # The space complexity will be O(K) since we need to store
	 * the top ‘K’ numbers in the heap.
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static List<Integer> KLargestNumbersInArray(int[] arr, int k) {

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		for (int i = 0; i < k; i++) {
			pQueue.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] > pQueue.peek()) {
				pQueue.poll();
				pQueue.add(arr[i]);
			}
		}

		return new ArrayList<Integer>(pQueue);
	}

	/**
	 * An Alternate Approach # Alternatively, we can use a Min Heap to find the Kth
	 * smallest number. We can insert all the numbers in the min-heap and then
	 * extract the top ‘K’ numbers from the heap to find the Kth smallest number.
	 * Initializing the min-heap with all numbers will take O(N) and extracting ‘K’
	 * numbers will take O(KlogN). Overall, the time complexity of this algorithm
	 * will be O(N+KlogN) and the space complexity will be O(N).
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int KthSamllestInArray(int[] arr, int k) {

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++)
			pQueue.add(arr[i]);

		for (int i = 1; i < k; i++)
			pQueue.poll();

		return pQueue.peek();
	}

	/**
	 * Problem Statement # Given an unsorted array of numbers, find Kth smallest
	 * number in it.
	 * 
	 * Please note that it is the Kth smallest number in the sorted order, not the
	 * Kth distinct element.
	 * 
	 * Time complexity # The time complexity of this algorithm is
	 * O(K*logK+(N-K)*logK), which is asymptotically equal to O(N*logK)
	 * 
	 * Space complexity # The space complexity will be O(K) because we need to store
	 * ‘K’ smallest numbers in the heap.
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int KthSamllestInArray2(int[] arr, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

		for (int i = 0; i < k; i++)
			maxHeap.add(arr[i]);

		for (int i = k; i < arr.length; i++) {
			if (maxHeap.peek() > arr[i]) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}

		return maxHeap.peek();
	}

	/**
	 * Given an array of n numbers and a positive integer k. The problem is to find
	 * k numbers with most occurrences, i.e., the top k numbers having the maximum
	 * frequency. If two numbers have the same frequency then the larger number
	 * should be given preference. The numbers should be displayed in decreasing
	 * order of their frequencies. It is assumed that the array consists of k
	 * numbers with most occurrences.
	 * 
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static List<Integer> KFrequentlyOccuringNumbers(int[] arr, int k) {
		List<Integer> res = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey())
						: Integer.compare(b.getValue(), a.getValue()));

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			maxHeap.add(entry);

		for (int i = 0; i < k; i++)
			res.add(maxHeap.poll().getKey());

		return res;
	}

	/**
	 * Problem Statement # Given an unsorted array of numbers, find the top ‘K’
	 * frequently occurring numbers in it.
	 * 
	 * Time complexity # The time complexity of the above algorithm is O(N+N*logK).
	 * 
	 * Space complexity # The space complexity will be O(N). Even though we are
	 * storing only ‘K’ numbers in the heap. For the frequency map, however, we need
	 * to store all the ‘N’ numbers.
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static List<Integer> KFrequentlyOccuringNumbers1(int[] arr, int k) {
		List<Integer> res = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
				(e1, e2) -> e1.getValue() - e2.getValue());

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
			if (minHeap.size() > k)
				minHeap.poll();
		}

		while (!minHeap.isEmpty()) {
			res.add(minHeap.poll().getKey());
		}
		return res;
	}
}

package pattern.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*Problem Statement #
Design a class to calculate the median of a number stream. The class should have the following two methods:

insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
*/
public class MedianOfAStream {

	PriorityQueue<Integer> minHeap; // to store right half of elements because right half are bigger numbers and we
									// need to find smallest og bigger numbers and vice versa
	PriorityQueue<Integer> maxHeap; // to store left half of elements

	public MedianOfAStream() {
		minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
	}

	public void insertNum(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else
			minHeap.add(num);

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		}

		else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}

	}

	public double findMedian() {
		// if size are equal it means number are even
		if (maxHeap.size() == minHeap.size())
			return (minHeap.peek() + maxHeap.peek()) / 2.0;

		return maxHeap.peek();
	}

	public double[] findSlidingWindowMedian(int[] num, int k) {

//		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
//		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

		double[] res = new double[num.length - k + 1];
		int count = 0;

		int windowEnd = 0;
		int windowStart = 0;
		while (windowEnd < k) {
			insertNum(num[windowEnd]);
			windowEnd++;
		}

		while (windowEnd < num.length +1) {

			res[count] = findMedian();
			count++;

			// remove element

			if (num[windowStart] > maxHeap.peek() || num[windowStart] == minHeap.peek())
				minHeap.remove(num[windowStart]);

			else
				maxHeap.remove(num[windowStart]);
			windowStart++;

			// balance heaps

			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.add(maxHeap.poll());
			}

			else if (minHeap.size() > maxHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
			
			if (windowEnd < num.length) {
				insertNum(num[windowEnd]);	
			}
			windowEnd++;

		}

		return res;
	}
}
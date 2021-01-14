package pattern.slidingwindow;

public class SlidingWindow {

	/**
	 * 
	 * Given an array of positive numbers and a positive number ‘k’, find the
	 * maximum sum of any contiguous subarray of size ‘k’. Time Complexity # The
	 * 
	 * time complexity: of the above algorithm will be O(N).
	 * 
	 * Space Complexity: The algorithm runs in constant space O(1).
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int maxSumSubArray(int[] arr, int k) {
		int maxSum = Integer.MIN_VALUE;
		int windowSum = 0;
		int startIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			windowSum = windowSum + arr[i];

			if (i >= k - 1) {
				maxSum = Math.max(windowSum, maxSum);
				maxSum = maxSum - arr[startIndex];
				startIndex++;
			}
		}

		return maxSum;
	}

}

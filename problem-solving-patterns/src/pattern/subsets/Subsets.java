package pattern.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Subsets {

	/**
	 * Problem Statement # Given a set with distinct elements, find all of its
	 * distinct subsets.
	 * 
	 * Time complexity # Since, in each step, the number of subsets doubles as we
	 * add each element to all the existing subsets, the time complexity of the
	 * above algorithm is O(2^N), where ‘N’ is the total number of elements in the
	 * input set. This also means that, in the end, we will have a total of O(2^N)
	 * subsets.
	 * 
	 * Space complexity # All the additional space used by our algorithm is for the
	 * output list. Since we will have a total of O(2^N) subsets, the space
	 * complexity of our algorithm is also O(2^N).
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> findSubsets(int[] nums) {

		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<Integer>());

		for (int i = 0; i < nums.length; i++) {

			int n = subsets.size();
			int currentItem = nums[i];

			for (int j = 0; j < n; j++) {
				List<Integer> newArray = new ArrayList<>(subsets.get(j));
				newArray.add(currentItem);
				subsets.add(newArray);
			}
		}
		return subsets;
	}

	public static Set<List<Integer>> findSubsetsWithDuplicates(int[] nums) {

		Set<List<Integer>> subsets = new HashSet<>();

		subsets.addAll(findSubsets(nums));

		return subsets;
	}

	/**
	 * Problem Statement # Given a set of numbers that might contain duplicates,
	 * find all of its distinct subsets.
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> findSubsetsWithDuplicate(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<Integer>());
		int tempSize = 0;
		int prev = Integer.MIN_VALUE;

		for (int curr : nums) {
			int end = subsets.size();
			int start = 0;

			if (curr == prev)
				start = tempSize;

			for (int i = start; i < end; i++) {
				List<Integer> temp = new ArrayList<Integer>(subsets.get(i));
				temp.add(curr);
				subsets.add(temp);
			}
			tempSize = end;
			prev = curr;
		}

		return subsets;
	}

	/**
	 * 
	 * Problem Statement # Given a set of distinct numbers, find all of its
	 * permutations.
	 * 
	 * 
	 * Time complexity # We know that there are a total of N! permutations of a set
	 * with ‘N’ numbers. In the algorithm above, we are iterating through all of
	 * these permutations with the help of the two ‘for’ loops. In each iteration,
	 * we go through all the current permutations to insert a new number in them on
	 * line 17 (line 23 for C++ solution). To insert a number into a permutation of
	 * size ‘N’ will take O(N) which makes the overall time complexity of our
	 * algorithm O(N*N!).
	 * 
	 * Space complexity # All the additional space used by our algorithm is for the
	 * result list and the queue to store the intermediate permutations. If you see
	 * closely, at any time, we don’t have more than N! permutations between the
	 * result list and the queue. Therefore the overall space complexity to store N!
	 * permutations each containing NN elements will be O(N*N!).
	 * 
	 * @param arr
	 * @return
	 */
	public static List<List<Integer>> findperm(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		Queue<List<Integer>> permutations = new LinkedList<>();

		permutations.add(new ArrayList<>());

		for (int num : arr) {
			int size = permutations.size();
			for (int i = 0; i < size; i++) {
				List<Integer> oldPermutation = permutations.poll();

				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<>(oldPermutation);

					newPermutation.add(j, num);

					if (newPermutation.size() == arr.length)
						result.add(newPermutation);
					else
						permutations.add(newPermutation);
				}
			}
		}
		return result;
	}
}

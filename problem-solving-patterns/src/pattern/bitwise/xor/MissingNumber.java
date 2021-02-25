package pattern.bitwise.xor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingNumber {

	/**
	 * Given an array of n-1 integers in the range from 1 to n, find the one number
	 * that is missing from the array.
	 * 
	 * @param arr
	 * @return
	 */
	private static int findMissingNumber(int[] arr) {
		int x1 = 1;
		int n = arr.length + 1;
		for (int i = 2; i <= n; i++) {
			x1 = x1 ^ i;
		}
		int x2 = arr[0];
		for (int i = 1; i < n - 1; i++) {
			x2 = x2 ^ arr[i];
		}

		return x1 ^ x2;
	}

	/**
	 * Problem Statement # In a non-empty array of integers, every number appears
	 * twice except for one, find that single number.
	 * 
	 * @param arr
	 * @return
	 */
	private static int findSingleNumber(int[] arr) {
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];

		}
		return res;
	}

	private static int[] findSingleNumbers(int[] arr) {
		int n1xn2 = 0;

		for (int i = 0; i < arr.length; i++) {
			n1xn2 = n1xn2 ^ arr[i];

		}

		int rightMostBit = 1;

		while ((rightMostBit & n1xn2) == 0) {
			rightMostBit = rightMostBit << 1;
		}

		int res1 = 0, res2 = 0;
		for (int num : arr) {
			if ((num & rightMostBit) == 0)
				res1 = res1 ^ num;
			else
				res2 = res2 ^ num;
		}

		return new int[] { res1, res2 };
	}

	private static List<Integer> findSingleNumbers2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : arr) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				list.add(entry.getKey());
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(findSingleNumbers2(new int[] { 1, 5, 3, 6, 4, 1, 5, 3 }));
	}

}

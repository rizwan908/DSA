package pattern.topKelements;

import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Integer> ree = KLargestNumbers.KLargestNumbersInArray(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
		System.out.println(ree);
		int k = KLargestNumbers.KthSamllestInArray(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
		System.out.println(k);
		KLargestNumbers.KFrequentlyOccuringNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		KLargestNumbers.KFrequentlyOccuringNumbers(new int[] { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 }, 4);
		KLargestNumbers.KFrequentlyOccuringNumbers1(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
		KLargestNumbers.KFrequentlyOccuringNumbers1(new int[] { 5, 12, 11, 3, 11 }, 2);
	}

}

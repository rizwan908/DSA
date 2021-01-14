package pattern.binarysearch.modified;

public class ModifiedBinarySearch {

	/**
	 * Given an array of lowercase letters sorted in ascending order, find the
	 * smallest letter in the given array greater than a given ‘key’.
	 * 
	 * Assume the given array is a circular list, which means that the last letter
	 * is assumed to be connected with the first letter. This also means that the
	 * smallest letter in the given array is greater than the last letter of the
	 * array and is also the first letter of the array.
	 * 
	 * 
	 * @param letters
	 * @param key
	 * @return
	 */
	public static char searchNextLetter(char[] letters, char key) {

		int n = letters.length;
		if (key < letters[0] || key < letters[n - 1])
			return letters[0];

		int start = 1;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key < letters[mid])
				end = mid - 1;
			else // key > letters[mid]
				start = mid + 1;

		}

		return letters[start % n];
	}

}

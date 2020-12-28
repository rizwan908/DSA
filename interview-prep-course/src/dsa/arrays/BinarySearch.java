package dsa.arrays;

/**
 * Implement Binary Search on a Sorted Array
 *
 */
public class BinarySearch {

	/**
	 * @param arr
	 * @param element
	 * @return index at which element exist or -1 if not found
	 */
	public static int binarySearch(int[] arr, int element) {
		int start = 0;
		int end = arr.length;

		while (end > start) {
			int mid = (start + (end - start) / 2);

			if (element == arr[mid])
				return mid;

			else if (element < arr[mid]) // if element is less, ignore right half
				end = mid - 1;

			else // // if element is greater, ignore left half
				start = mid + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		int index = binarySearch(array, 100);
		if (index == -1)
			System.out.println("Element not found");
		else
			System.out.println("index of element = " + index);
	}

}

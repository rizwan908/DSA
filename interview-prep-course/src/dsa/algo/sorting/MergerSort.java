package dsa.algo.sorting;

public class MergerSort {

	static void merge(int[] arr, int start, int mid, int end) {
		int sizeLArr = (mid - start) + 1;
		int sizeRArr = end - mid;

		// initialize left array and right array
		int[] leftArray = new int[sizeLArr];
		int[] rightArray = new int[sizeRArr];

		for (int i = 0; i < sizeLArr; i++) {
			leftArray[i] = arr[start + i];
		}

		for (int i = 0; i < sizeRArr; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}

		int indexLeft = 0;
		int indexRight = 0;

		int indexMerged = start;

		while (indexLeft < sizeLArr && indexRight < sizeRArr) {
			if (leftArray[indexLeft] > rightArray[indexRight]) {
				arr[indexMerged] = rightArray[indexRight];
				indexRight++;
			} else {
				arr[indexMerged] = leftArray[indexLeft];
				indexLeft++;
			}
			indexMerged++;
		}

		while (indexLeft < sizeLArr) {
			arr[indexMerged] = leftArray[indexLeft];
			indexLeft++;
			indexMerged++;
		}

		while (indexRight < sizeRArr) {
			arr[indexMerged] = rightArray[indexRight];
			indexRight++;
			indexMerged++;
		}

	}

	static void divide(int[] arr, int start, int end) {

		if (start < end) {

			int mid = (start + end) / 2;

			divide(arr, start, mid);
			divide(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

//        MergeSort ob = new MergeSort();
		divide(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

}

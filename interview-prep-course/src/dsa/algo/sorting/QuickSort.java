package dsa.algo.sorting;

public class QuickSort {

	private static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int i = low-1; // index of smaller element
		
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				
				// swap arr[i] and arr[j]
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// swap arr[i+1] with pivor or arr[high] in this case
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
		
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {

			// pivot is partitioning index
			int pivot = partition(arr, low, high);

			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);

		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 11, 6, 1 };
		quickSort(arr, 0, arr.length-1);
		System.out.println(arr);
	}

}

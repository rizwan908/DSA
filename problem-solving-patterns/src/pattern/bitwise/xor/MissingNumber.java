package pattern.bitwise.xor;

public class MissingNumber {

	private static int findmissingNumber(int[] arr) {
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

	public static void main(String[] args) {
		System.out.println(findmissingNumber(new int[] { 1, 5, 3, 6, 4 }));
	}

}

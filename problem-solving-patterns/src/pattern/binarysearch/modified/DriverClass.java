package pattern.binarysearch.modified;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ModifiedBinarySearch.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(ModifiedBinarySearch.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(ModifiedBinarySearch.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(ModifiedBinarySearch.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}

}

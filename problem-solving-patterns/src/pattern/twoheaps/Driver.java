package pattern.twoheaps;

public class Driver {

	public static void main(String[] args) {
		MedianOfAStream medianOfAStream = new MedianOfAStream();

//		medianOfAStream.insertNum(3);
//		medianOfAStream.insertNum(1);
//		System.out.println(medianOfAStream.findMedian());
//
//		medianOfAStream.insertNum(5);
//		System.out.println(medianOfAStream.findMedian());
//
//		medianOfAStream.insertNum(4);
//		System.out.println(medianOfAStream.findMedian());

		System.out.println(medianOfAStream.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3));

	}

}

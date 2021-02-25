package pattern.merge.intervals;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		List<List<Integer>> lis = new ArrayList<>();

		List<Integer> lis1 = new ArrayList<>();
		lis1.add(1);
		lis1.add(2);

		List<Integer> lis2 = new ArrayList<>();
		lis2.add(4);
		lis2.add(6);

		List<Integer> lis3 = new ArrayList<>();
		lis3.add(2);
		lis3.add(4);

		List<Integer> lis4 = new ArrayList<>();
		lis4.add(6);
		lis4.add(14);

		lis.add(lis1);
		lis.add(lis2);
		lis.add(lis3);
		lis.add(lis4);

		System.out.println(MergeIntervals.mergeInterval(lis));

	}
	
	
	

}

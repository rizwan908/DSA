package pattern.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public static List<List<Integer>> mergeInterval(List<List<Integer>> inter) {

		if (inter.size() < 2) {
			return inter;
		}

		Collections.sort(inter, (a, b) -> Integer.compare(a.get(0), b.get(0)));

		List<List<Integer>> res = new ArrayList<>();
		int start = inter.get(0).get(0);
		int end = inter.get(0).get(1);

		for (int i = 1; i < inter.size(); i++) {
			List<Integer> curr = inter.get(i);

			if (end >= (int) curr.get(0)) {
				end = Math.max(end, (int) curr.get(1));
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(start);
				temp.add(end);
				res.add(temp);
				start = inter.get(i).get(0);
				end = inter.get(i).get(1);
			}
		}

		List<Integer> temp1 = new ArrayList<>();
		temp1.add(start);
		temp1.add(end);
		res.add(temp1);
		return res;

	}

}

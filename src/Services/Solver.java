package Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Solver {

	private List<Integer> result = new ArrayList<Integer>();

	public List<Integer> getSubset() {
		return this.result;
	}

	// Return true if there exists a subarray of array[0..n] with given sum
	public boolean hasSubsetSum(int[] set, int n, int sum, Map<String, Boolean> lookup) {

		// return true if sum becomes 0 (subset found)
		if (sum == 0) {
			return true;
		}

		// base case: no items left or sum becomes negative
		if (n < 0 || sum < 0) {
			return false;
		}

		// construct an unique map key from dynamic elements of the input
		String key = n + "|" + sum;

		// if sub-problem is seen for the first time, solve it and
		// store its result in a map
		if (!lookup.containsKey(key)) {
			// Case 1. include current item in the subset (A[n]) & recur
			// for remaining items (n - 1) with decreased sum (sum - A[n])
			boolean include = hasSubsetSum(set, n - 1, sum - set[n], lookup);

			if (include) {
				this.result.add(n);
			}

			// Case 2. exclude current item n from subset and recur for
			// remaining items (n - 1)
			boolean exclude = false;
			if (!include) {
				exclude = hasSubsetSum(set, n - 1, sum, lookup);
			}
			// assign true if we get subset by including or excluding
			// current item
			lookup.put(key, include || exclude);

		}

		// return solution to current sub-problem
		return lookup.get(key);
	}

	public List<Integer> getSecondBestSubset(int[] set, int maximumPossibleSum) {

		List<Integer> result = new ArrayList<>();
		List<Integer> finalResult = new ArrayList<>();
		int score = 0;
		int bestScore = 0;
		int rotate = 0;
		int sum = maximumPossibleSum;

		while (rotate != set.length && sum != 0) {
			sum = maximumPossibleSum;
			result.clear();
			score = 0;
			for (int x = set.length - 1; x >= 0; x--) {
				if (set[x] <= sum) {
					sum = sum - set[x];
					result.add(x);
					score = score + set[x];
				}
				if (sum == 0)
					break;
			}
			rotate = rotate + 1;
			Collections.rotate(result, 1);
			if (score > bestScore) {
				bestScore = score;
				finalResult = new ArrayList<>(result);
			}
		}

		Collections.sort(finalResult);

		return finalResult;
	}
}

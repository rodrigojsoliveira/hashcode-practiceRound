package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solver {
	
	List<Integer> result = new ArrayList<Integer>();
	int elementSum = 0;
	
	public List<Integer> getResult() {
		return this.result;
	}
	
	public int getElementSum() {
		return this.elementSum;
	}
	
	// Return true if there exists a subarray of array[0..n] with given sum
	public boolean subsetSum(int[] A, int n, int sum,
									Map<String, Boolean> lookup) {

		
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
		if (!lookup.containsKey(key))
		{
			// Case 1. include current item in the subset (A[n]) & recur
			// for remaining items (n - 1) with decreased sum (sum - A[n])
			boolean include = subsetSum(A, n - 1, sum - A[n], lookup);
			
			if (include) {
				this.result.add(n);
				this.elementSum += A[n];
			}

			// Case 2. exclude current item n from subset and recur for
			// remaining items (n - 1)
			boolean exclude=false;
			if (!include) {
				exclude = subsetSum(A, n - 1, sum, lookup);
			}
			// assign true if we get subset by including or excluding
			// current item
			lookup.put(key, include || exclude);
			
		}

		// return solution to current sub-problem
		return lookup.get(key);
	}
}


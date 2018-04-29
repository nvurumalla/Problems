package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array of integers, find two numbers such that they add up to a specific target number
*/
public class TwoSum1 {

	public void twoSumInSortedArray(int[] a, int sum) {
		
	}
	
	public List<Pair> findUniquePairs(int[] a, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Pair> result = new ArrayList<>();
		Set<Integer> temp = new HashSet<>();
		
		for (int i : a) {
			if (map.containsKey(i)) {
				if (!temp.contains(i)) {
					Pair p = new Pair(i, map.get(i));
					result.add(p);
					temp.add(i);
					temp.add(map.get(i));
				}
				continue;
			}
			map.put(sum-i, i);
		}
		
		return result;
	}
	
	public class Pair {
		private int a;
		private int b;
		
		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public Pair(int a, int b) {
			this.setA(a);
			this.setB(b);
		}
		
		@Override
		public boolean equals(Object obj) {
			Pair p = (Pair) obj;
			if (p.getA() == this.a || p.getB() == this.a) {
				return true;
			}
			return false;
		}
	}
	
	public int[] findTwoSum(int[] a, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		
//		for (int i : a) {
//			if (map.containsKey(i)) {
//				result[0] = i;
//				result[1] = map.get(i);
//				return result;
//			}
//			map.put(sum-i, i);
//		}
//		map.clear();
		
		for (int i = 0 ; i < a.length; i++) {
			if (map.containsKey(sum-a[i])) {
				result[0] = i;
				result[1] = map.get(sum-a[i]);
				return result;
			}
			map.put(a[i], i);
		}
		return null;
	}
}
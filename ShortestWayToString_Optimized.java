package week13.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//TC- O(n log k)
//SC - O(n)
//https://leetcode.com/problems/shortest-way-to-form-string/description/
public class ShortestWayToString_Optimized {
	public int shortestWayToString(String s, String t) {
		HashMap<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch))
				map.put(ch, new ArrayList<>());
			map.get(ch).add(i);
		}
		int i = 0;
		int j = 0;
		int count = 1;
		while (j < t.length()) {
			char b = t.charAt(j); // target character
			if (!map.containsKey(b))
				return -1;
			List<Integer> list = map.get(b);

			int k = Collections.binarySearch(list, i);
			if (k < 0) {
				k = -k - 1; // important - not exact match of idx
			}
			if (k == list.size()) {
				count++;
				i = list.get(0);
			} else {
				i = list.get(k);
			}
			i++;
			j++;
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "bab";
		String t = "bbab";
		ShortestWayToString_Optimized obj = new ShortestWayToString_Optimized();
		System.out.println(obj.shortestWayToString(s, t));

	}

}

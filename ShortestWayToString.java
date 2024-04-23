package week13.day5;
//TC - O(m*n)
//SC - O(1)
import java.util.HashSet;

public class ShortestWayToString {
	public int shortestWayToString(String s, String t) {
		HashSet<Character> set = new HashSet<>();  //O(1)
		for (char ch : s.toCharArray()) {
			set.add(ch);
		}
		int i = 0;
		int j = 0;
		int count = 1;
		while (j < t.length()) {
			char b = t.charAt(j); // target character
			if (!set.contains(b))
				return -1;
			if (s.charAt(i) == b) {
				i++;
				j++;
				if(j==t.length())
					return count;
			} else {
				i++;
			}
			if(i==s.length()) {
				i=0;
				count++;
			}
				
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "xyz"; 
		String t = "xzyxz";
		ShortestWayToString obj = new ShortestWayToString();
		System.out.println(obj.shortestWayToString(s, t));
	}

}

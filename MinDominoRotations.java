package week13.day5;
//TC - O(n)
//SC - O(1)
//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = findRotations(tops, bottoms, tops[0]);
        if (rotations == -1)
            rotations = findRotations(tops, bottoms, bottoms[0]);
        return rotations;
    }

    public int findRotations(int[] tops, int[] bottoms, int target) {
        int topCount = 0;
        int bottomCount = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == target && bottoms[i] == target)
                continue;
            if (tops[i] == target) {
                bottomCount++; // 4
            } else if (bottoms[i] == target) {
                topCount++; // 3
            } else {
                return -1;
            }
        }
        return Math.min(topCount, bottomCount);
    }
}
public class MinDominoRotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 2018.8.29
/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
*/

class Solution {
    public int minMoves(int[] nums) {
        int needMoves = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                needMoves += i * (min - nums[i]);
                min = nums[i];
            } else {
                needMoves += nums[i] - min;
            }
        }
        return needMoves;
    }
}
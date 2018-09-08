// 2018.9.7
/*
https://leetcode.com/problems/optimal-division/description/
*/

class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        //最佳解為 x1/(x2/x3/.../xn)
        switch (nums.length) {
            case 1:
                sb.append(nums[0]);
                break;
            case 2:
                sb.append(nums[0]).append('/').append(nums[1]);
                break;
            default:
                sb.append(nums[0]).append('/').append('(');
                for (int i = 1; i < nums.length - 1; ++i) {
                    sb.append(nums[i]).append('/');
                }
                sb.append(nums[nums.length - 1]).append(')');
                break;
        }
        return sb.toString();
    }
}
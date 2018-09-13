// 2018.9.10
/*
https://leetcode.com/problems/single-element-in-a-sorted-array/description/
*/

// BUG：當nums[0] = Integer.MIN_VALUE，且為落單的數
//      或 當nums[nums.length-1] = Integer.MAX_VALUE，且為落單的數
//      會出錯
//可以用一變數紀錄，上一次mid，若mid與之前比較無變化，即可跳出迴圈，return 答案
//即可解決BUG
//
//解法：二分搜尋法，判斷mid值為奇偶數，與哪邊的值相等，得知該往哪邊搜尋
class Solution {
    
    int[] nums;
    
    public int singleNonDuplicate(int[] nums) {
        this.nums = nums;
        int min = 0;
        int max = nums.length - 1;
        int mid = max / 2;
        
        for (int i = 0; i < 10; ++i) {
            int left = mid - 1;
            int right = mid + 1;
            if (get(left) < nums[mid] && nums[mid] < get(right)) {
                break;
            }
            if ((mid & 1) == 0) {
                if (get(left) == nums[mid] ) {
                    max = mid;
                    mid = (max + min) / 2;
                } else {
                    min = mid;
                    mid = (max + min + 1) / 2;
                }
            } else {
                if (get(right) == nums[mid] ) {
                    max = mid;
                    mid = (max + min) / 2;
                } else {
                    min = mid;
                    mid = (max + min + 1) / 2;
                }
            }
        }
        return nums[mid];
    }
    
    private int get(int index) {
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= nums.length) {
            return Integer.MAX_VALUE;
        } else {
            return nums[index];
        }
        
    }
    
}
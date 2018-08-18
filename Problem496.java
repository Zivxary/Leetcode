// 2018.8.16
/*
https://leetcode.com/problems/next-greater-element-i/description/
*/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        
        for (int i = 0; i < nums2.length; i++) {
            for (int j = list.size() - 1; j >= 0; j-- ) {
                if (list.get(j) < nums2[i]) {
                    map.put(list.remove(j), nums2[i]);
                }
            }
            list.add(nums2[i]);
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return result;
    }
}

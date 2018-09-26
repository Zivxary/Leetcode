// 2018.9.18
/*
https://leetcode.com/problems/intersection-of-two-arrays/description/
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1)
                                .boxed()
                                .collect(Collectors.toSet());
        
        return IntStream.of(nums2)
                        .filter(i -> set.contains(i))
                        .distinct()
                        .toArray();
    }
}
// 2018.8.21
/*
https://leetcode.com/problems/fair-candy-swap/description/
*/
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        boolean reverse = A.length < B.length;
        Set<Integer> set = new HashSet<>();
        int[] tmpA = reverse ? B : A;
        int[] tmpB = reverse ? A : B;
        int sumA = 0;
        int sumB = 0;
        
        for (int i : tmpA) {
            sumA += i;
            set.add(i);
        }
        for (int i : tmpB) {
            sumB += i;
        }
        
        int diff = (sumA - sumB) / 2;
        for(int i : tmpB) {
            if(!set.contains(i + diff)) {
                continue;
            }
            return reverse ? new int[]{i, i + diff} : new int[]{i + diff, i};
        }
        return new int[]{0, 0};
    }
    
}
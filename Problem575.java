// 2018.8.11
/*
https://leetcode.com/problems/distribute-candies/description/
*/
class Solution 
{
    public int distributeCandies(int[] candies) 
    {
        Set<Integer> set = new HashSet();
        for(int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        return candies.length/2 >= set.size() ? set.size() : candies.length/2 ;
    }
}

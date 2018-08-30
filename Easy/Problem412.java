// 2018.8.13
/*
https://leetcode.com/problems/fizz-buzz/description/
*/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>(n);
        IntStream
            .range(1, n+1)
            .forEach(i -> {
                if (i % 15 == 0)
                    list.add("FizzBuzz");
                else if( i%5 == 0)
                    list.add("Buzz");
                else if (i%3 == 0)
                    list.add("Fizz");
                else
                    list.add(i+"");
            });
        return list;
    }
}

// 2018.8.19
/*
https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
*/
class Solution {
    private Set<Integer> primeSet = new HashSet<Integer>();
    
    Solution() {
        final int[] primes = {
            2, 3, 5, 7, 11, 13, 17, 19
        };
        for (int prime :primes) {
            primeSet.add(prime);
        }
    }
    
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; ++i) {
            if (isPrime(i)) {
               count++; 
            }
        }
        return count;
    }
    
    private boolean isPrime(int num) {
        Integer setBits = 0;
        while (num > 0) {
            if ((num & 1) > 0) {
                ++setBits;
            }
            num >>= 1;
        }
        
        return primeSet.contains(setBits);
    }
}

// 2018.9.3
/*
https://leetcode.com/problems/complex-number-multiplication/description/
*/

class Solution {
    
    public String complexNumberMultiply(String a, String b) {
        int[] numA = createComplexNumber(a);
        int[] numB = createComplexNumber(b);
        int[] numAns = multiply(numA, numB);
        return convert(numAns);
    }
    
    //num = new int[2]
    //num[0] = real num
    //num[1] = imag num
    private int[] createComplexNumber(String s) {
        int[] num = new int[2];
        int i;
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '+') {
                break;
            }
        }
        num[0] = Integer.parseInt(s.substring(0, i));
        num[1] = Integer.parseInt(s.substring(i + 1, s.length() - 1));
        return num;
    }
    
    private int[] multiply(int[] numA, int[] numB) {
        int[] result = new int[2];
        result[0] = numA[0] * numB[0] - numA[1] * numB[1];
        result[1] = numA[1] * numB[0] + numA[0] * numB[1];
        return result;
    }
    
    private String convert(int[] num) {
        return num[0] + "+" + num[1] + "i";
    }
}
// 2018.9.8
/*
https://leetcode.com/problems/fraction-to-recurring-decimal/description/
*/

//通過測試數 28/37

//第28測試根本是硬幹...
//3XX位數才一循環,循環開頭還有6個0
//之後再修正

class Solution {
    
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
           return "0"; 
        }
        boolean positive = ((numerator >>> 31) ^ (denominator >>> 31)) == 1 ;
        //System.out.println(positive);
        numerator = Math.abs(numerator);
        //System.out.println("分子\t" + numerator);
        denominator = Math.abs(denominator);
        //System.out.println("分母\t" + denominator);
        String ans = getPositiveDecimal(numerator, denominator);
        return (positive ? "-" : "") + ans; 
    }
    
    
    private String getPositiveDecimal(int numerator, int denominator) {
        
        //整數部分，不含小數、小數點
        String sNum = numerator / denominator + "";
        
        //小數部分，不含小數點
        //例：1.1(6) -> 0.1666...
        int a = getNumeratorWithoutQuotient(numerator, denominator);
        int b = denominator;
        String sDecimal = getExactDecimal(a, b, 3000);
        
        //小數無值，回傳整數
        if(sDecimal.length() == 0) {
            //System.out.println("return整數\t");
            return sNum;
        }
        
        //整數 + "." + 非循環小數
        //例：0.1(6) -> 0.1
        int index = Math.min(sDecimal.length(), noCyclic(denominator));
        String ans = sNum + "." + sDecimal.substring(0, index);
        //System.out.println("非循環\t" + ans);
        
        //擷取循環小數部分
        //0.1(6) -> 66666...
        String sLongCyclicDecimal = sDecimal.substring(index);
        //System.out.println("長循環\t" + sLongCyclicDecimal);
        if(sLongCyclicDecimal.length() == 0) {
            System.out.println("return非循環\t");
            return ans;
        }
        
        //取得循環部分
        String sCyclicDecimal = getCyclicDecimal(sLongCyclicDecimal);
        //System.out.println("循環" + sCyclicDecimal);
        
        ans += "(" + sCyclicDecimal + ")";
        //System.out.println("答案" + ans);
        return ans;
    }
    
    //回傳商為0的分子，例：8/7 回傳 1、5/3 回傳 2;
    private int getNumeratorWithoutQuotient(int numerator, int denominator) {
        return numerator - numerator / denominator * denominator;
    }
    
    //計算小數部分之字串
    //numerator：分子，要小於denominator
    //denominator：分母
    //len：小數位數
    //return：只含小數部分字串，例：0.2345 只回傳 2345
    private String getExactDecimal(int numerator, int denominator, int len) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < len) {
            if (numerator == 0) {
                break;
            }
            numerator *= 10;
            int count = 0;
            while( numerator >= denominator) {
                numerator -= denominator;
                count++;
            }
            sb.append(count);
        }
        return sb.toString();
    }
    
    //計算不循環小數位數
    //denominator：分母
    //例：0.1(6) 回傳 1、0.331(001) 回傳 3
    private int noCyclic(int denominator) {
        int a = getMultiple((double)denominator, 2);
        int b = getMultiple((double)denominator, 5);
        return Math.max(a, b);
    }
    
    //取得倍數
    private int getMultiple(double num, int divisor) {
        int mult = 0;
        while (getDecimal(num / divisor) == 0) {
            num /= divisor;
            ++mult;
        }
        return mult;
    }
    
    //取小數部分，例 1.2345 回傳 0.2345
    private double getDecimal(double num) {
        return num - (int)num;
    }
    
    //取得循環部分
    private String getCyclicDecimal(String decimal) {
        int index = 1; 
        while(index < decimal.length() / 7) {
            String[] test = new String[7];
            for(int i = 0; i < 7; ++i) {
                test[i] = decimal.substring(i * index, (i + 1) * index);
            }
            if (equalArray(test)) {
                break;
            }
            ++index;
        }
        return decimal.substring(0 , index);
    }
    
    //驗證陣列值市府都相等，是 就回傳 true
    private boolean equalArray(String[] test) {
        for (int i = 1; i < test.length; ++i) {
            if (!test[0].equals(test[i])) {
                return false;
            }
        }
        return true;
    }
}

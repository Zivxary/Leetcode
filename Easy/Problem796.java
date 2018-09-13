// 2018.9.12
/*
https://leetcode.com/problems/rotate-string/description/
*/

class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0) {
            return true;
        }
        int index = 0;
        for(;;) {
            index = B.indexOf(A.charAt(0), index);
            if (index == -1) {
                break;
            }
            String restoreString = B.substring(index) + B.substring(0, index);
            if(A.equals(restoreString)) {
                return true;
            }
            ++index;
        }
        return false;
    }
}

//論壇上的解法
public boolean rotateString(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
}
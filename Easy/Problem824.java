// 2018.8.25
/*
https://leetcode.com/problems/goat-latin/description/
*/
class Solution {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        tail.append("maa");
        String[] strArray = S.split(" ");
        for (String s : strArray) {
            switch(s.charAt(0)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    sb.append(s);
                    break;
                default:
                    sb.append(s.substring(1, s.length()))
                      .append(s.charAt(0));
                    break;
            }
            sb.append(tail).append(' ');
            tail.append('a');
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }
}
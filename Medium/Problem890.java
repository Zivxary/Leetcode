// 2018.8.31
/*
https://leetcode.com/problems/find-and-replace-pattern/description/
*/

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new LinkedList<>();
        MyMap map = new MyMap();
        for (int i = 0; i < words.length; ++i) {
            map.init();
            int j;
            for (j = 0; j < words[i].length(); j++) {
                char letter1 = words[i].charAt(j);
                char letter2 = pattern.charAt(j);
                if (!map.checkMatch(letter1, letter2)) {
                    break;
                }
            }
            if (j == words[i].length()) {
               list.add(words[i]); 
            }
        }
        return list;
    }
    
    private class MyMap {
        int[] wordMap;
        int[] patternMap;
        
        public MyMap() {
            wordMap = new int[26];
            patternMap = new int[26];
        }
        
        public void init() {
            Arrays.fill(wordMap, -1);
            Arrays.fill(patternMap, -1);
        }
        
        public boolean checkMatch(char word, char pattern) {
            int key = word - 'a';
            int val = pattern - 'a';
            if (wordMap[key] == -1 && patternMap[val] == -1) {
                wordMap[key] = val;
                patternMap[val] = key;
                return true;
            } else if (wordMap[key] != val || patternMap[val] != key) {
                return false;
            }
            return true;
        }
    }
}
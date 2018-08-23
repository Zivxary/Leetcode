// 2018.8.12
/*
https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
*/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Set<String> words = new HashSet<>();
        Set<String> uncommonWords = new HashSet<>();
        String[] wordsArray = (A + " " + B).split(" ");
        for (String word : wordsArray) {
            if (words.contains(word)) {
                uncommonWords.remove(word);
            } else {
                uncommonWords.add(word);
            }
            words.add(word);
        }
        return uncommonWords.toArray(new String[uncommonWords.size()]);
    }
}
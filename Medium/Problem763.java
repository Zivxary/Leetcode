// 2018.9.2
/*
https://leetcode.com/problems/partition-labels/description/
*/

class Solution {
    
    //紀錄字元出現起始與終點位置
    private class Range {
        public int start;
        public int end;
        
        public Range(int start) {
            this.start = start;
            this.end = start;
        }
        
        public Range(Range that) {
            this.start = that.start;
            this.end = that.end;
        }
        
        public int getLength() {
            return end - start + 1;
        }
    }
    
    //紀錄 字元 -> 字元出現起始與終點位置
    Map<Character, Range> charMap;
    
    //紀錄 不重複出現字元順序
    List<Character> charList;
    
    //題目提供的Method
    public List<Integer> partitionLabels(String S) {
        setCharInfo(S);
        return findPartitionLength();
    }
    
    //依字串初始化Map、List;
    private void setCharInfo(String S) {
        charMap = new HashMap<>();
        charList = new LinkedList<>();
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (charMap.containsKey(ch)) {
                charMap.get(ch).end = i;
            } else {
                charMap.put(ch, new Range(i));
                charList.add(ch);
            }
        }
    }
    
    //取得範圍並加入清單
    private List<Integer> findPartitionLength() {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < charList.size();) {
            Range range = new Range(getRange(i));
            i = modifyRange(range, i);
            result.add(range.getLength());
        }
        return result;
    }
    
    //檢查range內字元的Range，是否重疊並超出range，是則修改range
    //return 下一部分的開頭指標
    private int modifyRange(Range range, int index) {
        while(++index < charList.size()) {
                Range tmp = getRange(index);
                if (tmp.start > range.end) {
                    break;
                }
                if (tmp.end > range.end) {
                    range.end = tmp.end;
                }
        }
        return index;
    }
    
    //簡化取值
    private Range getRange(int index) {
        return charMap.get(charList.get(index));
    }
    
}
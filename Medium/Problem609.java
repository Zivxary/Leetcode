// 2018.9.26
/*
https://leetcode.com/problems/find-duplicate-file-in-system/description/
*/

class Solution {
    
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : paths) {
            String[] ss = s.split(" ");
            String path = ss[0];
            
            for (int i = 1; i < ss.length ; ++i) {
                String file = ss[i];
                int index = file.indexOf('(');
                String name = path + "/" + file.substring(0, index);
                String content = file.substring(index, file.length() - 1);
                
                if (map.containsKey(content)) {
                    map.get(content).add(name);
                } else {
                    List<String> list = new LinkedList<>();
                    list.add(name);
                    map.put(content, list);
                }
            }
        }
        
        List<List<String>> result = new LinkedList<>();
        
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }
        }
        
        return result;
    }
}
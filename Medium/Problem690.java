// 2018.9.11
/*
https://leetcode.com/problems/employee-importance/description/
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        //建立Map，用來找查員工資料
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        //紀錄importance相加結果
        int result = 0;
        //用佇列 存取 該Employee及其subordinates
        //換用Stack、List皆可，無影響
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee e = queue.remove();
            result += e.importance;
            for (Integer i : e.subordinates) {
                queue.add(map.get(i));
            }
        }
        
        return result;
    }
}
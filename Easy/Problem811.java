// 2018.8.24
/*
https://leetcode.com/problems/subdomain-visit-count/description/
*/

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < cpdomains.length; i++) {
            int index = cpdomains[i].indexOf(" ");
            int times = Integer.parseInt(cpdomains[i].substring(0, index));
            String domain = cpdomains[i].substring(index + 1);
            map.compute(domain, (k, v) -> v == null ? times : v + times);
            int dot = 0;
            for (int j = 0; j < domain.length(); j++ ) {
                if (domain.charAt(j) != '.') {
                    continue;
                }
                map.compute(domain.substring(++j), (k, v) -> v == null ? times : v + times);
                dot++;
                if (dot >= 2) {
                    break;
                }
            }
        }
        List<String> list = new ArrayList(map.size());
        for (String key : map.keySet()) {
            list.add(map.get(key) + " " + key);
        }
        return list;
    }
}
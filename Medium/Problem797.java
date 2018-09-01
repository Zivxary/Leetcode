// 2018.9.1
/*
https://leetcode.com/problems/all-paths-from-source-to-target/description/
*/
class Solution {
    
    List<LinkedList<Integer>> pathList;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int endNode = graph.length - 1;
        initPathList();
        for (int i = 0; i < pathList.size(); i++) {
            LinkedList<Integer> path = pathList.get(i);
            int node = path.getLast();
            while (node != endNode) {
                int[] nextNodes = graph[node];
                addOtherPath(path, nextNodes);
                node = nextNodes[0];
                path.add(node);
            }
        }
        return AnswerList();
    }
    
    private void initPathList() {
        pathList = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        pathList.add(path);
    }
    
    private void addOtherPath(LinkedList<Integer> path, int[] nextNodes) {
        for (int j = 1; j < nextNodes.length; ++j) {
            LinkedList<Integer> otherPath = new LinkedList<Integer>(path);
            otherPath.add(nextNodes[j]);
            pathList.add(otherPath);
        }
    }
    
    private List<List<Integer>> AnswerList() {
        List<List<Integer>> ans = new LinkedList<>();
        for (LinkedList<Integer> path : pathList) {
            ans.add(path);
        }
        return ans;
    }
    
}
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] used = new boolean[graph.length];
        path.add(0);
        backtrack(graph, 0, used);
        return res;
    }
    private void backtrack(int[][] graph, int start, boolean[] used){
        if (path.get(path.size()-1) == graph.length-1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[start].length; i++){
            if (used[graph[start][i]] == false){
                path.add(graph[start][i]);
                used[graph[start][i]] = true;
                backtrack(graph, graph[start][i], used);
                used[graph[start][i]] = false;
                path.remove(path.size()-1);
            } 
        }
    }
}
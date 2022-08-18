class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] vis = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                vis[i][j]=0;
        
        for(int a=0;a<m;a++) {
            for(int b=0;b<n;b++) {
                if(grid[a][b] == '1' && vis[a][b] != 1) {
                    dfs(grid, vis, a, b);
                    ans+=1;
                }
            }
        }
        return ans;
    }
    
    public void dfs(char[][] grid, int[][] vis, int a, int b) {
        if(a<0 || a>=grid.length || b<0 || b>=grid[0].length || grid[a][b] == '0' || vis[a][b] == 1) return;
        vis[a][b]=1;
        dfs(grid, vis, a+1, b);
        dfs(grid, vis, a-1, b);
        dfs(grid, vis, a, b+1);
        dfs(grid, vis, a, b-1);
        return;
    }
}
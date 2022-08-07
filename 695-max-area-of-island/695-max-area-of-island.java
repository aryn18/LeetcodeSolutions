class Solution {
    public static final int[][] DIRECTIONS = new int[][]{new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 1) {
                    // int area = bfs(grid, i, j);
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        
        if(!isValidMove(grid, i, j)) {
            return 0;
        }
        
        // mark visited
        grid[i][j] = 0;
        int area = 1; // current point's area
        
        for(int[] dir : DIRECTIONS) {
            int xDir = i + dir[0];
            int yDir = j + dir[1];
            
            area += dfs(grid, xDir, yDir);
        }
        
        return area;
    }
    
    private int bfs(int[][] grid, int i, int j) {
        
        // arr - {i,j}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        grid[i][j] = 0; // mark visited
        
        int area = 0;
        
        while(!q.isEmpty()) {
            
            area++;
            int[] point = q.remove();
            int x = point[0];
            int y = point[1];
            
            for(int[] dir : DIRECTIONS) {
                
                int xDir = x + dir[0];
                int yDir = y + dir[1];
                
                if(isValidMove(grid, xDir, yDir)) {
                    grid[xDir][yDir] = 0; // mark visited
                    q.add(new int[]{xDir, yDir});
                }
            }
        }
        
        return area;
    }
    private boolean isValidMove(int[][] grid, int i, int j) {
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return false;
        }
         return true;
    }
}
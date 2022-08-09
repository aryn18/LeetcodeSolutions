class Solution {
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] seen = new int[mat.length][mat[0].length];
        int distance = 1;
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    seen[i][j] = 1;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] node = queue.pollFirst();
                int row = node[0];
                int col = node[1];
                
                if(row - 1 >= 0 && seen[row - 1][col] == 0) {
                    queue.add(new int[]{row - 1, col});
                    seen[row - 1][col] = 1;
                    mat[row - 1][col] = distance;
                }
                
                if(row + 1 < mat.length && seen[row + 1][col] == 0) {
                    queue.add(new int[]{row + 1, col});
                    seen[row + 1][col] = 1;
                    mat[row + 1][col] = distance;
                }
                
                if(col - 1 >= 0 && seen[row][col - 1] == 0) {
                    queue.add(new int[]{row, col - 1});
                    seen[row][col - 1] = 1;
                    mat[row][col - 1] = distance;
                }
                
                if(col + 1 < mat[0].length && seen[row][col + 1] == 0) {
                    queue.add(new int[]{row, col + 1});
                    seen[row][col + 1] = 1;
                    mat[row][col + 1] = distance;
                }
            }
            
            distance++;
        }
        
        return mat;
    }
}
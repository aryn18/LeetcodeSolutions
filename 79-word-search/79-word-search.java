class Solution {
    char[] dir = new char[]{'D', 'R', 'U', 'L'};
    int[] di = new int[]{1,0,-1,0};
    int[] dj = new int[]{0,1,0,-1};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) &&  recursion(i, j, board, word, 0)){
                   return true;
                }
            }
        }
        return false;        
    }
    
    boolean recursion(int i, int j, char[][] board, String word, int count) {
        
        if(count == word.length())
            return true;
        
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 
                             || board[i][j] != word.charAt(count) || visited[i][j]) {
            return false;
        } 
        visited[i][j] = true;
        for(int x = 0; x < 4; x++){
            if(recursion(i+di[x], j+dj[x], board, word, count +1) == true) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
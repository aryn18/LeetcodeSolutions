class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n =  matrix.length;
        int[] oneD = new int[n*n];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j= 0; j < n; j++){
                oneD[index] = matrix[i][j];
                index++;
            }
        }
        Arrays.sort(oneD);
        return oneD[k-1];
    }
}
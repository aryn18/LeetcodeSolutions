class Solution {

private int maxSumSubarray(int[] A) {
    int min = 0, res = Integer.MIN_VALUE;
    for(int sum: A) {
        res = Math.max(res, sum - min);
        min = Math.min(min, sum);
    }
    return res;
}
private int maxSumSubarray(int[] A, int k) {
    int res = maxSumSubarray(A);
    if(res <= k) return res;
    res = Integer.MIN_VALUE;
    TreeSet<Integer> set = new TreeSet<>();
    set.add(0);
    for(int sum: A) {
        Integer old = set.ceiling(sum - k);
        if(old != null) {
            if(sum - old > res) {
                res = sum - old;
                if(res == k) return res;
            }
        }
        set.add(sum);
    }
    return res;
}
public int maxSumSubmatrix(int[][] matrix, int k) {
    int m = matrix.length, n = m == 0 ? 0 : matrix[0].length, res = Integer.MIN_VALUE;
    boolean groupingRows = true;
    if(m > n) {
        int temp = m; m = n; n = temp;
        groupingRows = false;
    }
    int[] sum = new int[n];
    for(int i = 0; i < m; i++) {
        Arrays.fill(sum, 0);
        for(int j = i; j < m; j++) {
            int pre = 0;
            if(groupingRows) {
                for(int t = 0; t < n; t++) sum[t] += pre += matrix[j][t];
            } else {
                for(int t = 0; t < n; t++) sum[t] += pre += matrix[t][j];
            }
            res = Math.max(res, maxSumSubarray(sum, k));
            if(res == k) return res;
        }
    }
    return res;
}
}
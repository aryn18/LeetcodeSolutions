class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
     int startRowInd = 0;
    int endRowInd = n;
    int startColInd = 0;
    int endColInd = n;
    int value=1;
    
    while(startRowInd < endRowInd && startColInd < endColInd)
    {
        for(int i=startColInd ;i<endColInd;i++)
        {
            ans[startRowInd][i]=value;
            value++;
        }
        startRowInd++;
        for(int i=startRowInd ;i<endRowInd;i++)
        {
            ans[i][endColInd-1]=value;
            value++;
        }
        endColInd--;
        
        if(startRowInd < endRowInd)
        {
            for(int i=endColInd-1;i>=startColInd;i--)
            {
                ans[endRowInd-1][i]=value;
                value++;
            }
            endRowInd--;
        }
        if(startColInd < endColInd)
        {
            for(int i=endRowInd-1;i>=startRowInd;i--)
            {
                ans[i][startColInd]=value;
                value++;
            }
            startColInd++;
        }
        
    }
    return ans;
    }
}
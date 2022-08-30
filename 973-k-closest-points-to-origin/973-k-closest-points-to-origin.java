class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxhp=new PriorityQueue<>(new Comparator<int[]>()
        {
            public int compare(int[] a,int[] b)
            {
                return ((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
            }
        });
        
        for(int[] i:points)
        {
            maxhp.add(i);
            if(maxhp.size()>k)
            {
                maxhp.poll();
            }
        }
        int res[][]=new int[k][2];
        int j=0;
        while(maxhp.size()>0)
        {
            res[j++]=maxhp.poll();
        }
        return res;
                                                       
    }
}
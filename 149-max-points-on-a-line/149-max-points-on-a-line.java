class Solution {
    public int maxPoints(int[][] points) {
        int N = points.length;
        Map<Double, Set<Integer>>[] arr = (Map<Double, Set<Integer>>[]) new HashMap[N];
        for(int i = 0; i<N; i++){
            arr[i] = new HashMap<Double, Set<Integer>>();
        }
        
        int rt = 0;
        for(int i = 0; i<N; i++){
            Map<Double, Set<Integer>> mp = arr[i];
            for(int j=i+1; j<N; j++){
                double p = slope(points[i], points[j]);
                if(!mp.containsKey(p))
                    mp.put(p, new HashSet<>());
                mp.get(p).add(j);
            }
            
            for( Set<Integer> st : mp.values())
                rt  = Math.max(rt, st.size());
        }
        
        return rt+1;
    }
    
    private double slope(int[] p1, int[] p2){
        if(p1[0] == p2[0])
            return Double.MAX_VALUE;
        if(p1[1] == p2[1])
            return 0.0;

        int diffY = p1[1] - p2[1];
        int diffX = p1[0] - p2[0];
        return ((double) diffY)/((double) diffX);
    }
}
class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = arr.length,ans=0,count=0;
        
        for(int i=0;i<len;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])>=len/2)return 1;
        }
        ArrayList<Integer>v = new ArrayList<Integer>();
        for(Integer it:map.values()){
            v.add(it);
        }
        Collections.sort(v,Collections.reverseOrder());
        for(int i=0;i<v.size();i++){
            count++;
            ans+=v.get(i);
            if(ans>=len/2)return count;
        }
        return 0;
        
    }
}
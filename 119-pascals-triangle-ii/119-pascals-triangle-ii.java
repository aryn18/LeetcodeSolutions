class Solution {
    public List<Integer> getRow(int index) {
        List<Integer> ans = new LinkedList<>();
        ans.add(1);
        for(int i=0;i<index;i++)
        { 
        List<Integer> temp = new LinkedList<>();
            temp.add(1);
            for(int j=0;j<ans.size()-1;j++)
            {
                temp.add(ans.get(j)+ans.get(j+1));
            }
            temp.add(1);
            ans = new LinkedList<>(temp);
        }
        return ans;
        
    }
}
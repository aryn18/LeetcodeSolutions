class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        helper(n,ans,sb,0,0);
        
        return ans;
    }
    private void helper(int n, List<String> ans, StringBuilder sb,int openPren, int closePren){
        
        if(closePren == n && openPren == n){
            ans.add(sb.toString());
            return;
        }
        if(openPren != n){
            sb.append("(");
            helper(n,ans,sb,openPren+1,closePren);
            sb.deleteCharAt(sb.length()-1);
        }
        if(openPren > closePren){
            sb.append(")");
            helper(n,ans,sb,openPren,closePren+1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}